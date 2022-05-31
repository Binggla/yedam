package co.micol.prj.notice.web;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		
		System.out.println(file);
		
		String fileName = file.getOriginalFilename();	// 실제 파일 이름을 받아온다.
		
		// 파일이 있을 때만 진행
		if(fileName != null) {
			// 새로운 파일 객체를 생성하는데, bean 객체로 미리 생성해둔 saveDir(경로)에 fileName을 붙여준다. C:\temp\'fileName'
			// saveDir,fileName 공백 넣지 말 것!
			File target = new File(saveDir,fileName);	
			// 실제 저장 경로를 vo 객체에 담는다.
			vo.setNoticeDir(target.toString());
			// 실제 파일 이름을 vo 객체에 담는다.
			vo.setNoticeAttech(fileName);				
			try {
				FileCopyUtils.copy(file.getBytes(), target);	// FileCopyUtils.copy(File in, File out)
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		
		}
		
		noticeDao.noticeInsert(vo);
		return "redirect:noticeList.do";
	}
	
}
