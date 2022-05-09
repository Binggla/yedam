package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@WebServlet("/StudentGetServlet")
public class StudentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StudentGetServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식으로 넘어오면 cmd=search
		// cmd=null일 경우에는 json 반환

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		String id = request.getParameter("student_id");
		
		// 한 건 조회
		if (cmd != null && cmd.equals("search")) {
			
			StudentDAO dao = new StudentDAO();
			Student stud = dao.searchStudent(id);
			
//			 if (student != null) {
//		            response.setContentType("text/html; charset=utf-8");
//		            response.getWriter().println("<form action='StudentGetServlet' method='post'>");
//		            response.getWriter().println("<h3>학생번호: " + student.getStudentNo() + "</h3>");
//		            response.getWriter().println("<h3>이름 : " + student.getStudentName() + "</h3>");
//		            response.getWriter().println(
//		                  "<h3>영어:<input type='number' name='eng_score' value='" + student.getEngScore() + "'> </h3>");
//		            response.getWriter().println(
//		                  "<h3>국어: <input type='number' name='kor_score' value='" + student.getKorScore() + "'> </h3>");
//		            response.getWriter().println("<input type='hidden' name='cmd' value='mod'>");
//		            response.getWriter()
//		                  .println("<input type='hidden' name='user_id' value=" + student.getStudentNo() + ">");
//		            response.getWriter()
//		                  .println("<input type='hidden' name='user_name' value="+ student.getStudentName()+">");
//		            response.getWriter().println("<input type='submit' id='mod' value='수정'>");
//		            response.getWriter().println("</form>");
//		         } else {
			
			if (stud != null) {
				response.getWriter().println("<h3 name=\"student_id\">학생 번호 : " + stud.getStudentNo() + "</h3>");
				response.getWriter().println("<h3 name=\"student_name\">학생 이름 : " + stud.getStudentName() + "</h3>");
				response.getWriter().println("<form name=\"scoreFrm\" action=\"StudentGetServlet\" method=\"post\" value=\"modScore\">");
				response.getWriter().println("<input type=\"hidden\" name=\"cmd\" value=\"modScore\">");
				response.getWriter().println("<input type=\"hidden\" name=\"student_id\" value=\""+stud.getStudentNo()+"\">");
				response.getWriter().println("<input type=\"hidden\" name=\"student_name\" value=\""+stud.getStudentName()+"\">");
				response.getWriter().println("<h3>영어 점수 : <input type=\"number\" name=\"eng_score\" value=" + stud.getEngScore() + "></h3>");
				response.getWriter().println("<h3>국어 점수 : <input type=\"number\" name=\"kor_score\" value=" + stud.getKorScore() + "></h3>");
				response.getWriter().println("<input type=\"submit\" value=\"점수 변경\" name=\"modScoreBtn\"></form><br>");
				response.getWriter().println("<a href=\"studentList.jsp\">학생 목록으로 이동</a>");
				response.getWriter().println(
						"<script>let modScoreBtn = document.getElementById('modScoreBtn'); "
						+ "modScoreBtn.addEventListener('click', () => { let scoreFrm = document.forms.scoreFrm; console.log(\"click\"); scoreFrm.submit(); });</script>"
						);
	
			} else {
				response.getWriter().print("<script>alert('존재하지 않는 번호입니다.')</script>");
			}
			

		} else {
			
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.stuList(); // [{},{},{}]
			
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식으로 넘어오면 cmd=add
		// cmd=null일 경우에는 json 반환
		
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		String id = request.getParameter("student_id");
		String name = request.getParameter("student_name");
		String eng = request.getParameter("eng_score");
		String kor = request.getParameter("kor_score");
		
		// 한 건 입력
		if (cmd != null && cmd.equals("add")) {
			
			Student stud = new Student();
			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));
			
			StudentDAO dao = new StudentDAO();
			dao.addStudent(stud);
			
			response.getWriter().print("<script>alert('입력 성공')</script>");
		
		// id 값으로 한 건 삭제
		} else if (cmd != null && cmd.equals("del")) {

			StudentDAO dao = new StudentDAO();
			if (dao.delStudent(id)) {
				response.getWriter().print("<script>alert('삭제 성공')</script>");
			} else {
				response.getWriter().print("<script>alert('삭제 실패')</script>");
			}
			
		// 한 건 수정
		} else if (cmd != null && cmd.equals("mod")) {
		
			Student stud = new Student();
				
			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));
			
			StudentDAO dao = new StudentDAO();
			dao.modStudent(stud);

		}  else if (cmd != null && cmd.equals("modScore")) {
			
			Student stud = new Student();
			
			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));
			
			StudentDAO dao = new StudentDAO();
			dao.modStudent(stud);
				
		} else {
			
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.stuList(); // [{},{},{}]
			
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
			
		} 
		
		response.sendRedirect("studentList.jsp");	// submit 이후에 studentList.jsp 페이지로 이동해라.

	}
	
}
