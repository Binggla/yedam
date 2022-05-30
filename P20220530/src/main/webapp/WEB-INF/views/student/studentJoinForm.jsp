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
	<div><h1>학생 등록</h1></div>
	<form id="frm" action="studentJoin.do" onsubmit="return formCheck()" method="post">
		<div>
			<table border="1">
				<tr>
					<th width="150">아이디</th>
					<td width="380">
						<input type="email" id="id" name="id" required="required">&nbsp;&nbsp;
						<button id="btn" type="button" onclick="idCheck()">중복 확인</button>
						<input type="hidden" id="checkId" value="N">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" id="password" name="password" required="required">
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인</th>
					<td>
						<input type="password" id="password1" required="required">
					</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>
						<input type="text" id="name" name="name" required="required">
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type="text" size="50" id="address" name="address">
					</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>
						<input type="text" id="tel" name="tel">
					</td>
				</tr>
				<tr>
					<th>생년월일</th>
					<td>
						<input type="date" id="birthday" name="birthday" required="required">
					</td>
				</tr>
				<tr>
					<th>나이</th>
					<td>
						<input type="text" id="age" name="age" required="required">
					</td>
				</tr>
			</table>
		</div><br/>
		<div>
			<input type="submit" value="등록">&nbsp;&nbsp;
			<input type="reset" value="취소">
		</div>
	</form>
	</div>
	
<script type="text/javascript">

	function formCheck() {
		
		if (frm.checkId.value === 'N') {
			alert('아이디 중복 확인을 해주세요.');
			return false;
		} 
		
		if (frm.password.value != frm.password1.value) {
			alert('비밀번호가 일치하지 않습니다.');
			frm.password.value = '';
			frm.password1.value = '';
			frm.password.focus();
			return false;
		}
	}
	
	function idCheck() {
		let id = frm.id.value;
		fetch('ajaxIdCheck.do?id='+id, {
			method: 'GET'
		}).then(response => {
			return response.text()
		}).then(data => {
			if (data != 'N') {
				alert(id + '는 사용할 수 있습니다.');
				const target = document.getElementById('btn');
				target.disabled = true;
				frm.checkId.value = data;
			} else {
				alert(id + '는 사용할 수 없습니다.');
				frm.id.value = '';
				frm.id.focus();
			}
		}) 
			.catch();
	}
</script>
</body>
</html>