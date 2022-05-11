<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberView/memberInsert.jsp</title>
<%-- <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/web.css"> --%>
</head>
<body>
	<c:if test="${!empty error}"><script>alert('${error }')</script></c:if>
	<h3>회원가입</h3>
	<form action="${pageContext.servletContext.contextPath }/memberInsert.do" method="post" enctype="multipart/form-data">
	<ul>
		<li><label for="uid">아이디</label><input id="uid" type="text" name="id"></li>
		<li><label for="upwd">비밀번호</label><input id="upwd" type="password" name="pwd"></li>
		<li><label for="uname">이름</label><input id="uname" type="text" name="name"></li>
		<li><label for="umail">메일</label><input id="umail" type="email" name="email"></li>
		<li><label for="uimg">이미지</label><input id="img" type="file" name="profile"><input type="submit" value="join"></li>
	</ul>
	</form>
	<jsp:include page="../memberResult/home.jsp"></jsp:include>
</body>
</html>