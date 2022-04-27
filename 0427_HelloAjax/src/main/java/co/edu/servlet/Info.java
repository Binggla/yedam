package co.edu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Info extends HttpServlet {
	
	// HttpServlet이 정해놓은 방식으로 구현
	// Info -> 서버에서 실행되는 페이지.
	
	// HelloAjax는 아래의 생명주기를 가진다.
	// Info 페이지 요청 -> Init() 최초 1회 실행 -> Service() -> Destroy()
	// Init()은 만들어주지 않아도 기존에 가지고 있는 메서드가 실행된다.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 응답 정보 내보내기 : 한글이 포함되어 있으면 UTF-8로 변환해서 내보내기
		resp.setCharacterEncoding("UTF-8");
		// 응답 정보를 보여주는 페이지
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<h3>서블릿 페이지</h3>");
		out.print("<h3>안녕하세요</h3>");
		out.print("<a href=\"../index.html\">index</a>");
		
		
		// web.xml로 요청
	}
	
}