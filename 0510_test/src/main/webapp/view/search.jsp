<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>도서 조회.</title>
    <link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/css.css">
</head>

<body>

	<c:if test="${!empty error }"><script>alert('${error }')</script></c:if>
    <h3>도서 조회</h3>
    <form action="${pageContext.servletContext.contextPath }/searchBook.do" method="get">
        <input type="text" name="bookCode" id="">
        <input type="hidden" name="job" value="search">
        <input type="submit" value="조회">
    </form>
    
    <a class="home" href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>

</html>