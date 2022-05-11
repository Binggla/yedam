package co.dev.web;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVo;

public class MemberInsertJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 멀티파트 요청인지 체크
		boolean isMulti = ServletFileUpload.isMultipartContent(req);
		MemberVo vo = null;
		
		if(isMulti) {
			
			String saveDir = "upload";
			saveDir = req.getServletContext().getRealPath(saveDir);
			int maxSize = 1024 * 1024 * 10;
			String encoding = "UTF-8";
			
			MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
			
			String id = multi.getParameter("id");
			String pwd = multi.getParameter("pwd");
			String name = multi.getParameter("name");
			String email = multi.getParameter("email");
			
//			if(id.isEmpty() || name.isBlank() || pwd.isBlank() || email.isBlank()) {
//				req.setAttribute("error", "모든 항목을 입력하세요.");
//				req.getRequestDispatcher("memberView/ajax.html").forward(req, resp);
//				return;
//			}
			
			vo = new MemberVo();
			vo.setId(id);
			vo.setName(name);
			vo.setPwd(pwd);
			vo.setEmail(email);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
		} else {
			
			String id = req.getParameter("id");
			String pwd = req.getParameter("pwd");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			vo = new MemberVo();
			vo.setId(id);
			vo.setName(name);
			vo.setPwd(pwd);
			vo.setEmail(email);
			
			MemberService service = new MemberService();
			service.memberInsert(vo);
			
		}
		
		// json 형태의 결과 반환
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(vo));
		

	}

}
