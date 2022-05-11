<%@page import="co.dev.vo.MemberVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberResult/memberListOutput.jsp</title>
<%-- <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/web.css"> --%>
</head>
<body>
<c:choose>
	<c:when test="${empty all }"><h3>회원 정보가 없습니다.</h3></c:when>
	<c:otherwise>
		<table border="1">
			<thead><tr><th>아이디</th><th>이름</th><th>이메일</th><th>비밀번호</th><th>이미지</th></tr></thead>
			<tbody>
				<c:forEach items="${all }" var="member">
					<tr>
						<td>${member.id }</td>
						<td>${member.name }</td>
						<td>${member.email }</td>
						<td>${member.pwd }</td>
						<td>
							<c:if test="${!empty member.profile }">
								<img width="50px" src="${pageContext.servletContext.contextPath }/upload/${member.profile }">
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
<jsp:include page="home.jsp"></jsp:include>

</body>
</html>