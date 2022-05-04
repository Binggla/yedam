<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberSearch.jsp</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/web.css">
</head>
<body>
	<c:if test="${!empty error}"><script>alert('${error }')</script></c:if>
	<h3>삭제할 회원 검색</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get" >
		<input type="text" name="id" placeholder="ID 입력">
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="search">
	</form>
	
	<c:choose>
		<c:when test="${!empty result }"><script>alert('${result }')</script></c:when>
		<c:otherwise>
			<form action="${pageContext.servletContext.contextPath }/memberDelete.do" method="post">
				<br>아이디 : ${member.id } <br>
				이름 : ${member.name } <br>
				이메일 : ${member.email }
				<input type="hidden" name="id" value="${member.id }">
				<input type="submit" value="delete">
			</form>
		</c:otherwise>
	</c:choose>
	
	<jsp:include page="../memberResult/home.jsp"></jsp:include>

</body>
</html>