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
	
		<div>
			<h1>공지사항</h1>
		</div>
		
		<table id="tb" border="1">
			<tr>
				<th width="70">번호</th>
				<td width="870">${n.noticeId }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${n.noticeTitle }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${n.noticeName }</td>
			</tr>
			<tr>
				<th>작성일자</th>
				<td>${n.noticeDate }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${n.noticeHit }</td>
			</tr>
			<tr>
				<th height="400">내용</th>
				<td>${n.noticeContents }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
					<td>
					<c:choose>
						<c:when test="${!empty n.noticeAttech }">
							<a href="downLoad.do?saveName=${n.noticeDir }&fileName=${n.noticeAttech }">${n.noticeAttech }</a>
						</c:when>
						<c:otherwise>
							첨부파일 없음
						</c:otherwise>
					</c:choose>
					</td>
			</tr>
			
		</table><br />
		
		<div>
			<button type="button" onclick="location.href='noticeUpdateForm.do?noticeId=${n.noticeId }'">수정</button>
			<button type="button" onclick="deleteCheck();">삭제</button>
			<button type="button" onclick="location.href='noticeList.do'">목록</button>
		</div>
	</div>
<script>

	function deleteCheck() {
		let result = confirm('정말로 삭제하시겠습니까?');
		if (result) {
			location.href = `noticeDelete.do?noticeId=${n.noticeId }`;
		}
	}

</script>
</body>
</html>