package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryText
 */
@WebServlet("/queryText")
public class QueryText extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public QueryText() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] hobbies = request.getParameterValues("hobby");
		String gen = request.getParameter("gender");
		String rel = request.getParameter("religion");
		String intro = request.getParameter("intro");
		
		PrintWriter out = response.getWriter();
		out.print("<h3>id : " + id + "</h3>");
		out.print("<h3>pwd : " + pwd + "</h3>");
		out.print("<h3>name : " + name + "</h3>");
		out.print("<ul>");
		for (String hobby : hobbies) {
			out.print("<li>" + hobby + "</li>");
		}
		out.print("</ul>");
		out.print("<h3>성별 : " + gen + "</h3>");
		out.print("<h3>종교 : " + rel + "</h3>");
		out.print("<h3>자기소개 : " + intro + "</h3>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
