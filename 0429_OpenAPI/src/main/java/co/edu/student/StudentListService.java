package co.edu.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/studentList.json")
public class StudentListService extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HelloAjax는 아래의 생명주기를 가진다.
		// html 페이지 요청 -> Init() 최초 1회 실행 -> Service() -> Destroy()
		// Init()은 만들어주지 않아도 기존에 가지고 있는 메서드가 실행된다.
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// [{"studentNo": ?, "studentName": "?", "engScore": ?, "korScore": ?}, {...}]
		StudentDAO dao = new StudentDAO();
		List<Student> list = dao.stuList();
		
		String jsonString = "[";
		for (int i=0; i<list.size(); i++) {
			jsonString += "{\"studentNo\": " + list.get(i).getStudentNo()
					+ ", \"studentName\": \"" + list.get(i).getStudentName()
					+ "\", \"engScore\": " + list.get(i).getEngScore()
					+ ", \"korScore\": " + list.get(i).getKorScore() + "}";
			
			// json Data의 마지막 데이터는 ,가 없어야 하기 때문에 if로 조건 추가
			if (i != list.size() - 1) {
				jsonString += ",";
			}
		}
		jsonString += "]";
		
		resp.getWriter().print(jsonString);
	}

}
