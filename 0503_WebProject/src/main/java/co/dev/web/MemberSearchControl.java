package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVo;

public class MemberSearchControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// memberView/memberSearch.jsp에서 id, job 값 받아오기
		String id = req.getParameter("id");
		String job = req.getParameter("job");
		
		
		// id값이 없을 경우 각 job값에 따라 페이지 전환
		String path = "";
		
		if (job.equals("search")) {
			path = "memberView/memberSearch.jsp";
		} else if (job.equals("update")) {
			path = "memberView/memberUpdate.jsp";
		} else if (job.equals("delete")) {
			path = "memberView/memberDelete.jsp";
		}
		
		if(id.isEmpty()) {
			req.setAttribute("error", "아이디를 입력하세요.");
			req.getRequestDispatcher(path).forward(req, resp);
		} 
		
		//
		MemberService service = new MemberService();
		MemberVo member = null;
		
		member = service.memberSearch(id);
		req.setAttribute("member", member);
		
		if (member == null) {
			req.setAttribute("result", "조회된 정보가 없습니다.");
		}
		
		if (job.equals("search")) {
			path = "memberResult/memberSearchOutput.jsp";
		}
	
		
		//
		req.getRequestDispatcher(path).forward(req, resp);
	}

}
