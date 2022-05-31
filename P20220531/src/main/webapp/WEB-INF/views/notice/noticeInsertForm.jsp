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
		<div><h1>게시글 등록</h1></div>
		<div>
			<form id="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="100">작성자</th>
						<td width="150"><input type="text" id="noticeName" name="noticeName"></td>
						<th width="100">작성일자</th>
						<td width="150"><input type="date" id="noticeDate" name="noticeDate"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><input type="text" id="noticeTitle" name="noticeTitle" size="58"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><textarea id="noticeContents" name="noticeContents" cols="60" rows="10"></textarea></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3"><input type="file" id="file" name="file"></td>
					</tr>
				
				</table>
			</div><br/>
			<div>
				<button type="submit">저장</button>
				<button type="reset">취소</button>
				<button type="button" onclick="location.href='noticeList.do'">목록</button>
			</div>
			</form>
			
		</div>
	</div>
</body>
</html>