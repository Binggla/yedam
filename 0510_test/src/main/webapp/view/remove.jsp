<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>도서 삭제 조회.</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/css.css">
</head>

<body>

	<c:if test="${!empty error }"><script>alert('${error }')</script></c:if>

    <h3>도서 삭제 조회</h3>
    <form action="${pageContext.servletContext.contextPath }/searchBook.do" method="get">
        <input type="text" name="bookCode" id="">
        <input type="hidden" name="job" value="remove">
        <input type="submit" value="조회">
    </form>

    <!-- 도서삭제를 위한 화면 작성코드를 입력하세요. -->
		<form action="${pageContext.servletContext.contextPath }/removeBook.do" method="post">
    	<ul>
        <li>book title : ${book.bookTitle }</li>
        <li>book author : ${book.bookAuthor }</li>
        <li>book press : ${book.bookPress }</li>
        <li>book price : ${book.bookPrice }<input type="submit" value="삭제"></li>
    	</ul>
    		<input type="hidden" name="bookCode" value=${book.bookCode }>
    		<input type="hidden" name="job" value="remove">
    </form>
    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>