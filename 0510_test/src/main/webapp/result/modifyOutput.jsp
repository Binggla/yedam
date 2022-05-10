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

	<h3>수정 결과</h3>
    <table border="1">
        <thead>
            <tr>
                <th>도서코드</th>
                <th>도서명</th>
                <th>도서저자</th>
                <th>도서출판사</th>
                <th>도서가격</th>
            </tr>
        </thead>
        <tbody>
        	<tr>
        		<td>${modVO.bookCode }</td>
        		<td>${modVO.bookTitle }</td>
        		<td>${modVO.bookAuthor }</td>
        		<td>${modVO.bookPress }</td>
        		<td>${modVO.bookPrice }</td>
        	</tr>
        
        </tbody>
    </table>
    <a href="${pageContext.servletContext.contextPath }/index.jsp">첫페이지</a>

</body>
</html>