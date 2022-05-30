<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberSearch.jsp</title>
<%-- <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/web.css ">--%>
</head>
<body>
	<c:if test="${!empty error}"><script>alert('${error }')</script></c:if>
	<h3>회원 정보 검색</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get" >
		<input type="text" name="id" placeholder="ID 입력">
		<input type="hidden" name="job" value="search">
		<input type="submit" value="search">
	</form>
	<jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>
</html>