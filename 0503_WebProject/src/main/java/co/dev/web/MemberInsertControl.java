package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.dev.service.MemberService;
import co.dev.vo.MemberVo;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/json;charset=utf-8");
		
		String saveDir = "upload";
		saveDir = req.getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10;
		String encoding = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		System.out.println("입력 작업");
		String id = multi.getParameter("id");
		String pwd = multi.getParameter("pwd");
		String name = multi.getParameter("name");
		String email = multi.getParameter("email");
		String profile = multi.getFilesystemName("profile");
		
		if(id.isEmpty() || name.isBlank() || pwd.isBlank() || email.isBlank() || profile.isBlank()) {
			req.setAttribute("error", "모든 항목을 입력하세요.");
			req.getRequestDispatcher("memberView/memberInsert.jsp").forward(req, resp);
			return;
		}
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setProfile(profile);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		
		req.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(req, resp);

	}

}
