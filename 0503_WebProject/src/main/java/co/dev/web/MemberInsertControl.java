package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVo;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("입력 작업");
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberVo vo = new MemberVo();
		vo.setId(id);
		vo.setName(name);
		vo.setPwd(pwd);
		vo.setEmail(email);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		
		req.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(req, resp);

	}

}
