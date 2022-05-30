<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인화면(index.jsp)</title>

</head>
<body>
	<%-- 
	<h3>Welcome!</h3>
	<a href="${pageContext.request.contextPath }/memberView/memberInsert.tiles">회원 정보 생성</a><br>
	<a href="${pageContext.request.contextPath }/memberView/memberSearch.tiles">회원 정보 검색</a><br>
	<a href="${pageContext.request.contextPath }/memberView/memberUpdate.tiles">회원 정보 수정</a><br>
	<a href="${pageContext.request.contextPath }/memberView/memberDelete.tiles">회원 정보 삭제</a><br>
	<a href="${pageContext.request.contextPath }/memberList.do">회원 목록</a><br>
	<a href="${pageContext.request.contextPath }/memberView/ajax.html">Ajax 호출</a>
	--%>
	
	<div class="border-end bg-white" id="sidebar-wrapper">
	  <div class="sidebar-heading border-bottom bg-light">Welcome!</div>
	  <div class="list-group list-group-flush">
	      <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberInsert.tiles">회원 정보 생성</a>
	      <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberSearch.tiles">회원 정보 검색</a>
	      <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberUpdate.tiles">회원 정보 수정</a>
	      <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberView/memberDelete.tiles">회원 정보 삭제</a>
	      <a class="list-group-item list-group-item-action list-group-item-light p-3" href="${pageContext.request.contextPath }/memberList.do">회원 목록</a>
	  </div>
  </div>
</body>
</html>