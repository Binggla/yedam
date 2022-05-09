<%@page import="co.edu.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>response.jsp</title>
</head>
<body>
	<%
		//String id = (String) request.getAttribute("id"); // 서블릿에서 넘어오는 값은 객체 타입이므로 String으로 형변환해준다.
		//String name = (String) request.getAttribute("name");
		// Student stud = (Student) request.getAttribute("result");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		
	%>
	
	<h3>id : <%=id %></h3>
	<h3>name : <%=name %></h3>
<!-- <h3>no : stud.getStudentNo() %></h3> -->	
<!-- <h3>name : stud.getStudentName() %></h3> -->	
</body>
</html>