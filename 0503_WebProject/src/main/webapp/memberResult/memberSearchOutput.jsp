<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult/memberSearchOutput.jsp</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/web.css">
</head>
<body>
	<h3>조회 결과</h3>
	<c:if test="${!empty result }"><h4>${result }</h4></c:if>
	<c:if test="${!empty member }">
		<h4>${member.id } / ${member.name } / ${member.email } / ${member.pwd }</h4>
	</c:if>
	<jsp:include page="home.jsp"></jsp:include>
</body>
</html>