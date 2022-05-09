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
	<h3>수정할 회원 검색</h3>
	<form action="${pageContext.servletContext.contextPath }/memberSearch.do" method="get" >
		<input type="text" name="id" placeholder="ID 입력">
		<input type="hidden" name="job" value="update">
		<input type="submit" name="searchBtn" value="search"><br><br>
	</form>
	
	<c:choose>
		<c:when test="${!empty result }"><script>alert('${result }')</script></c:when>
		<c:otherwise>
		
			<form action="${pageContext.servletContext.contextPath }/memberUpdate.do" method="post">
				아이디 : ${member.id } <input type="hidden" name="id" value="${member.id }"><br>
				이름 : ${member.name } <input type="hidden" name="name" value="${member.name }"><br>
				이메일 : ${member.email } <input type="hidden" name="email" value="${member.email }"><br>
				비밀번호 : ${member.pwd } <input type="hidden" name="pwd" value="${member.pwd }">
				<input type="submit" value="update">
			</form>
		</c:otherwise>
	</c:choose>
	<jsp:include page="../memberResult/home.jsp"></jsp:include>

</body>
</html>