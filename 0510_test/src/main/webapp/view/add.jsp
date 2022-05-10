<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>도서 등록.</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/css.css">
</head>

<body>
<c:if test="${!empty error}"><script>alert('${error }')</script></c:if>
    <h3>도서 등록</h3>
    <form action="${pageContext.servletContext.contextPath }/addBook.do" method="post">
    <ul>
        <li><label for="btitle">제목</label><input id="btitle" type="text" name="title"></li>
        <li><label for="bauthor">저자</label><input id="bauthor" type="text" name="author"></li>
        <li><label for="bpress">출판사</label><input id="bpress" type="text" name="press"></li>
        <li><label for="bprice">가격</label><input id="bprice" type="text" name="price"><input type="submit" value="등록"></li>
    </ul>
    </form>
    
    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>