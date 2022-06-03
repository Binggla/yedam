package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	// IoC Container에 bean 객체로 담겨있는 saveDir를 가져와줘!
	@Autowired
	private String saveDir;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(1, "all"));
		return "notice/noticeList";
	}
	
	@RequestMapping("/noticeInsertForm.do")
	public String noticeInsertForm() {
		return "notice/noticeInsertForm";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		
		String fileName = file.getOriginalFilename();	// 실제 파일 이름을 받아온다.
		
		// 파일이 있을 때만 진행
		if(fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
			
			// UUID(Universally Unique IDentifier, 범용 고유 식별자)
			// 네트워크 상에서 고유성이 보장되는 id를 만들기 위한 표준 규약
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid + fileName.substring(fileName.indexOf("."));	// uuid.xml로 설정됨
			
			// 새로운 파일 객체를 생성하는데, bean 객체로 미리 생성해둔 saveDir(경로)에 fileName을 붙여준다. C:\temp\'fileName'
			// saveDir,fileName 공백 넣지 말 것!
			File target = new File(saveDir,saveFileName);	
			// 업로드된 파일 이름을 vo 객체에 담는다.
			vo.setNoticeAttech(fileName);
			// 실제로 저장된 파일 이름을 vo 객체에 담는다.
			vo.setNoticeDir(saveFileName);
			try {
				FileCopyUtils.copy(file.getBytes(), target);	// FileCopyUtils.copy(File in, File out)
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		
		noticeDao.noticeInsert(vo);
		return "redirect:noticeList.do";
	}
	
	@PostMapping("/getContent.do")
	public String getContent(NoticeVO vo, Model model) {
		noticeDao.noticeHitUpdate(vo.getNoticeId());
		model.addAttribute("n", noticeDao.noticeSelect(vo));
		
		return "notice/noticeContent";
	}
	
	@RequestMapping("/downLoad.do")
	public void downLoad(@RequestParam("saveName") String saveName, @RequestParam("fileName") String fileName, HttpServletResponse response) {
		// @RequestParam : 하나의 파라미터 값을 불러오는 어노테이션. GET 방식일 때만 사용 가능하다. 
		// http://localhost/prj/getContent.do?saveName= 으로 넘어올 것.
		// 파일을 다운받을 때, UDDI로 변환된 파일명이 아닌 실제 파일명으로 다운 받기 위해서 두 개의 파라미터를 모두 넘겨받는다.
			
		try {
			
			// file을 배열로 전환
			// UUID로 변환된 파일명으로 파일을 가져온다.
			// File.separator는 '/'이다.
			byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(
					new File(saveDir + File.separator + saveName));
			
			// 파일 다운받을 수 있게끔 설정
				// 모든 타입의 데이터를 전송할 때 사용
			response.setContentType("application/octet-stream");
				// 파일 길이만큼 사이즈 설정
			response.setContentLength(fileByte.length);
				// 파일을 다운받기 위한 설정으로, 업로드 시 실제 파일명으로 다운받을 수 있도록 한다.
			response.setHeader("Content-Disposition", "attachment; fileName=\""
					+ URLEncoder.encode(fileName, "UTF-8") + "\";");
			
			// 입출력 스트림
			response.getOutputStream().write(fileByte);	// 파일 저장
			response.getOutputStream().flush();
			response.getOutputStream().close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/noticeDelete.do") 
	public String noticeDelete(NoticeVO vo) {
		noticeDao.noticeDelete(vo);
		return "redirect:noticeList.do";
	}
	
	@RequestMapping("/noticeUpdateForm.do")
	public String noticeUpdateForm(NoticeVO vo, Model model) {
		model.addAttribute("n", noticeDao.noticeSelect(vo));
		return "notice/noticeUpdateForm";
	}
	
	@PostMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo, MultipartFile file) {
		
		String fileName = file.getOriginalFilename();	// 실제 파일 이름을 받아온다.
		
		if(fileName != null && !fileName.isEmpty() && fileName.length() != 0) {
			
			String uid = UUID.randomUUID().toString();
			String saveFileName = uid + fileName.substring(fileName.indexOf("."));
			
			File target = new File(saveDir,saveFileName);	
			vo.setNoticeAttech(fileName);
			vo.setNoticeDir(saveFileName);
			
			try {
				FileCopyUtils.copy(file.getBytes(), target);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		noticeDao.noticeUpdate(vo);
		
		return "redirect:noticeList.do";
	}
	
	@PostMapping("/ajaxSearchList.do")
	@ResponseBody
	public List<NoticeVO> ajaxSearchList(
			@RequestParam("state") int state, 
			@RequestParam("key") String key) {
		return noticeDao.noticeSelectList(state, key);
	}
	
}
