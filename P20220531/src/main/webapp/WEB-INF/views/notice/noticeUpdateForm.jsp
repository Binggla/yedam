<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>공지사항 수정</h1></div>
		<div>
			<form id="frm" action="noticeUpdate.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="150">${n.noticeName }</td>
						<th width="100">작성일자</th>
						<td width="150">${n.noticeDate }</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" id="noticeTitle" name="noticeTitle" size="58" value="${n.noticeTitle }"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea id="noticeContents" name="noticeContents" cols="60" rows="10">${n.noticeContents }</textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"><input type="file" id="file" name="file">
						<input type="hidden" id="noticeId" name="noticeId" value="${n.noticeId }">
						</td>
					</tr>
				
				</table>
			</div><br/>
			<div>
				<button type="submit">수정</button>
				<button type="reset">취소</button>
				<button type="button" onclick="location.href='noticeList.do'">목록</button>
			</div>
			</form>
			
		</div>
	</div>
</body>
</html>