<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>도서 수정 조회.</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/css.css">
</head>

<body>

	<c:if test="${!empty error }"><script>alert('${error }')</script></c:if>

    <h3>도서 수정 조회</h3>
    <form action="${pageContext.servletContext.contextPath }/searchBook.do" method="get">
        <input type="text" name="bookCode" id="">
        <input type="hidden" name="job" value="modify">
        <input type="submit" value="조회">
    </form>
    
    <!-- 도서수정을 위한 화면 작성코드를 입력하세요. -->
    <form action="${pageContext.servletContext.contextPath }/modifyBook.do" method="post">
    	<ul>
        <li><label for="btitle">book title</label><input id="btitle" type="text" name="title" value=${book.bookTitle }></li>
        <li><label for="bauthor">book author</label><input id="bauthor" type="text" name="author" value=${book.bookAuthor }></li>
        <li><label for="bpress">book press</label><input id="bpress" type="text" name="press" value=${book.bookPress }></li>
        <li><label for="bprice">book price</label><input id="bprice" type="number" name="price" value=${book.bookPrice }><input type="submit" value="수정"></li>
    	</ul>
    		<input type="hidden" name="bookCode" value=${book.bookCode }>
    		<input type="hidden" name="job" value="modify">
    		
    </form>

    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>