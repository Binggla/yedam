<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 정보 변수 지정 -->
	<sec:authentication property="principal" var="user"/>
	<!-- 로그인 되지 않았다면 참. -->
	<sec:authorize access="isAnonymous()">
		<a href="login.jsp">로그인</a>
	</sec:authorize>
	
	<!-- 로그인 했다면 참. -->
	<sec:authorize access="isAuthenticated()">
		<form action="${pageContext.request.contextPath }/logout" method="post">
			<sec:csrfInput/>
			${user.name }<br>
			${suser.name }
			<button type="submit">로그아웃</button>
		</form>
	</sec:authorize>
	
	<h1>톱 페이지입니다.</h1>
	<ul>
		<li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
	</ul>

</body>
</html>