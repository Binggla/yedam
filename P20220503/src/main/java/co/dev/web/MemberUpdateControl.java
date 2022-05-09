package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVo;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("수정 작업");
		
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		String email = req.getParameter("email");
		
		if(id.isEmpty() || name.isBlank() || pwd.isBlank() || email.isBlank()) {
			req.setAttribute("error", "모든 항목을 입력하세요.");
			req.getRequestDispatcher("memberView/memberUpdate.jsp").forward(req, resp);
			return;
		}
		
		
		MemberVo member = new MemberVo();
		member.setId(id);
		member.setName(name);
		member.setPwd(pwd);
		member.setEmail(email);
		
		MemberService service = new MemberService();
		service.memberUpdate(member);
		
		req.setAttribute("id", id);
		req.getRequestDispatcher("memberResult/memberUpdateOutput.jsp").forward(req, resp);
	}

}
