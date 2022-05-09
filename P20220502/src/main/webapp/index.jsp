<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h3>반갑습니다.</h3>
	
	<% // java 영역.
		String head = "유저 정보";
		out.println("<h3>" + head + "</h3>"); 			    // 내장 객체 out
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("user_id");		// 내장 객체 request
		String name = request.getParameter("user_name");
		out.println("<h4> 입력 값 : " + id + ", name : " + name);
	%>
	<br>
	<a href="student.do">Student Servlet</a>
</body>
</html>