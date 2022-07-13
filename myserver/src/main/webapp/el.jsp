<%@page import="java.util.Arrays"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h3>el</h3>
	
	<!-- Date formatting -->
	<fmt:parseDate value="2020-07-07 10:25" pattern="yyyy-MM-dd hh:mm" var="dt"/>
	<fmt:formatDate value="${dt }" pattern="yy-MM-dd" /><br>
	
	<!-- fn -->
	<c:set var="arr" value="<%=Arrays.asList(\"바나나\",\"사과\")%>" />
	배열 크기 : ${fn:length(arr) }<br>
	해당 단어 포함 여부(바나나) : ${fn:contains(arr, "바나나") }<br>
	
	
	<ul>
	<li><%=request.getParameter("id") %></li>
	<li>${param.id }</li>
	
	<li><%=request.getHeader("user-agent") %></li>
	<li>${header["user-agent"]}</li>
	
	<!-- referer : 이전 페이지 -->
	<li><%=request.getHeader("referer") %></li>
	<li>${header["referer"] }</li>
	
	<li><%=request.getAttribute("userid") %>
	<li>${requestScope.userid }
	<li><%=request.getAttribute("userid") %>
	<li>${sessionScope.userid }
	
	<li><%=request.getRequestURI() %>
	<li>${pageContext.request.requestURI }
	<li>${pageContext.request.getRequestURI() }
	</ul>
</body>
</html>
