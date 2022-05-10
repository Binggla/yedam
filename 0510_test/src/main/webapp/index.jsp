<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/css.css">
</head>

<body>
		<h2>Welcome!</h2><br>
    <a href="view/add.jsp">도서 등록</a><br>
    <a href="view/search.jsp">도서 검색</a><br>
    <a href="view/modify.jsp">도서 수정 검색</a><br>
    <a href="view/remove.jsp">도서 삭제 검색</a><br>
    <a href="listBook.do">도서 목록</a><br>

</body>

</html>