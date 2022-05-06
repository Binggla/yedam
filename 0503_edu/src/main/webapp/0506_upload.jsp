<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
</head>
<body>
	<h3>파일 업로드</h3>
	<form action="FileUploadServlet" name="frm" method="post" enctype="multipart/form-data">
		title : <input type="text" name="title"><br>
		content : <input type="text" name="content"><br>
		<input type="file" name="profile"><br>
		<input type="submit" value="upload">
	</form>
</body>
</html>