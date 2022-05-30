package co.edu.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/addStudServlet") // ajax 폴더의 post.html과 연동되는 servlet
public class AddStudServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// req (=request) : 사용자가 요청을 날린다.
		// resp (=response) : 웹서버가 응답을 한다.
		// 데이터를 받기 원하고, 데이터를 주는 과정을 요청이라고 한다. 자바에서는 요청도 객체로 만들어 전달하는데, 이 객체를 Response 객체라고 한다.
		
		// getParameterNames() : 현재 요청에 포함된 매개변수 이름을 열거 형태로 넘겨준다.
		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		String studentNo = req.getParameter("studNo");
		String studentName = req.getParameter("studName");
		String engScore = req.getParameter("eScore");
		String korScore = req.getParameter("kScore");
		
		Student stud = new Student();
		stud.setStudentNo(Integer.parseInt(studentNo));
		stud.setStudentName(studentName);
		stud.setEngScore(Integer.parseInt(engScore));
		stud.setKorScore(Integer.parseInt(korScore));
		
		
		// db insert 과정
		StudentDAO dao = new StudentDAO();
		boolean success = dao.addStudent(stud);
		if (success) {
			// {"retCode":"Success"} retcode라는 속성에 Success 삽입
			// {"retCode":"Success", "studNo":studentNo, "studName":studentName, "eScore":engScore, "kScore":korScore}
			resp.getWriter().println("{\"retCode\":\"Success\", \"studentNo\":"+studentNo+", \"studentName\":\""+studentName+"\", \"engScore\":"+engScore+", \"korScore\":"+korScore+"}");
		} else {
			// {"retCode":"Fail"} retcode라는 속성에 Fail 삽입
			resp.getWriter().println("{\"retCode\":\"Fail\"}");
		}
		
	}
	
}
