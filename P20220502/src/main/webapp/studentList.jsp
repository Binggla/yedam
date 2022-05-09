<%@page import="co.edu.Student"%>
<%@page import="java.util.List"%>
<%@page import="co.edu.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>studentList.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr><th>학생 번호</th><th>학생 이름</th><th>영어 점수</th><th>국어 점수</th></tr>
		</thead>
		<tbody>
			<% 
				StudentDAO dao = new StudentDAO();
				List<Student> list = dao.stuList();
				for (Student stud : list) {
					out.print("<tr><td><a href='StudentGetServlet?cmd=search&student_id="+stud.getStudentNo()+"'>"+stud.getStudentNo()+"</td><td>"+stud.getStudentName()+"</td><td>"+stud.getEngScore()+"</td><td>"+stud.getKorScore()+"</td></tr>");
					
				}
			%>
		</tbody>
	</table>
	<hr>
	<a href="form.jsp">돌아가기</a>
</body>
</html>