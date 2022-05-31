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
	<div><h1>로그인</h1></div>
	<div>
		<form id="frm" action="studentLogin.do" method="post">
	 		<div>
	 			<table border="1">
	 				<tr>
	 					<th width="150">아이디</th>
	 					<td width="200">
	 						<input type="email" id="id" name="id" 
	 						required="required" placeholder="Enter Your Email...">
	 					</td>
	 				</tr>
	 				<tr>
	 					<th>비밀번호</th>
	 					<td>
	 						<input type="password" id="password" name="password" 
	 						required="required"  placeholder="Enter Your Password...">
	 					</td>
	 				</tr>
	 			</table>
	 		</div><br/>
	 		<button type="submit">로그인</button>&nbsp;&nbsp;&nbsp;
	 		<button type="reset">취소</button>
	 	</form>
	</div>
	</div>
</body>
</html>