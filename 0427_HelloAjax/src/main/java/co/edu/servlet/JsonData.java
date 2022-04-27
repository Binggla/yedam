package co.edu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jsonData.do")
public class JsonData extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// [{"name":"지수빈", "age":"28"}, {"name":"지철민", "age":"35"}, {"name":"오주희", "age":"38"}]
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.getWriter().print("[{\"name\":\"지수빈\", \"age\":\"28\"}, {\"name\":\"지철민\", \"age\":\"35\"}, {\"name\":\"오주희\", \"age\":\"38\"}]");
		
	}
	
}
