<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult/memberDeleteOutput.jsp</title>
<%-- <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/web.css"> --%>
</head>
<body>
	<h3>아이디 ${id }의 삭제가 완료되었습니다.</h3>
	<jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>
</html>