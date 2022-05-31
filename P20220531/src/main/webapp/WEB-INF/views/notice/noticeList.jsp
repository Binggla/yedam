<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>공지사항</h1></div>
		<div>
			<form id="frm" action="" method="post">
				<select id="state" name="state">
					<option value="1">전체</option>
					<option value="2">작성자</option>
					<option value="3">제목</option>
					<option value="4">내용</option>
				</select>&nbsp;
				<input id="key" name="key" type="text" placeholder="검색어 입력">&nbsp;
				<button id="btn" type="button" onclick="searchNotice();">검색</button>
			</form>
		</div><br/>
		<div>
			<table id="tb" border="1">
				<thead>
					<tr>
						<th width="70">번호</th>
						<th width="150">작성자</th>
						<th width="300">제목</th>
						<th width="150">작성일자</th>
						<th width="70">조회수</th>
						<th width="70">첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!empty notices }">
						<c:forEach items="${notices }" var="n">
							<tr>
								<td>${n.noticeId }</td>
								<td>${n.noticeName }</td>
								<td>${n.noticeTitle }</td>
								<td>${n.noticeDate }</td>
								<td>${n.noticeHit }</td>
								<td>${n.noticeAttech }</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty notices }">
						<tr>
							<td colspan="6" align="center">게시글이 존재하지 않습니다.</td>
						</tr>
					</c:if>
				</tbody>
			</table>
		</div><br/>
		<div>
			<button type="button" onclick="location.href='noticeInsertForm.do'">글 등록</button>
		</div>
	</div>

</body>
</html>