<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session2.jsp</title>
</head>
<body>
	<%
		String id = (String) session.getAttribute("id");
		String pwd = (String) session.getAttribute("pwd");
		
	%>
		<h3>id : <%=id %></h3>
		<h3>pwd : <%=pwd %></h3>
</body>
</html>