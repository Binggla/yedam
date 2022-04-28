package co.edu.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/modStudServlet")
public class ModStudServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ModStudServlet() {
		super();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String no = req.getParameter("a");
		String name = req.getParameter("b");
		String eng = req.getParameter("c");
		String kor = req.getParameter("d");
		
		Student stud = new Student();
		stud.setStudentNo(Integer.parseInt(no));
		stud.setStudentName(name);
		stud.setEngScore(Integer.parseInt(eng));
		stud.setKorScore(Integer.parseInt(kor));
		
		StudentDAO dao = new StudentDAO();
		boolean success = dao.modifyStudent(stud);
		
		if (success) {
			resp.getWriter().println("{\"retCode\":\"OK\", \"studentNo\":"+no+", \"studentName\":\""+name+"\", \"engScore\":"+eng+", \"korScore\":"+kor+"}");
		} else {
			resp.getWriter().println("{\"retCode\":\"NG\"}");
		}
		
		
	}
	
	
	
}
