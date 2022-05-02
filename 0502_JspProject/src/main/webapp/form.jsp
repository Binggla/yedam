<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>form.jsp</title>
</head>
<body>
	<form name="frm" action="StudentGetServlet" method="get">
		<input type="hidden" name="cmd" value="search">
		학생 번호 : <input type="number" name="student_id" value="201"><br>
		학생 이름 : <input type="text" name="student_name" value="지수빙"><br>
		영어 점수 : <input type="number" name="eng_score" value="100"><br>
		국어 점수 : <input type="number" name="kor_score" value="100"><br>
		<input type="submit" value="조회">
		<input id="addBtn" type="button" value="입력">
		<input id="modBtn" type="button" value="수정">
		<input id="delBtn" type="button" value="삭제">
	</form>
	<form name="refrm">
	</form>
	<hr>
	<a href="studentList.jsp">학생 목록</a>
	
	<script>
		// 입력
		let btn = document.querySelector('#addBtn');
		btn.addEventListener('click', () => {	// 입력 버튼에 클릭 이벤트.
			let frm = document.forms.frm;
			
			frm.action = "StudentGetServlet";
			frm.method = "post";
			frm.cmd.value = "add";

			frm.submit(); // form의 submit 버튼.
		});
		
		// 삭제
		let delBtn = document.getElementById('delBtn');
		delBtn.addEventListener('click', () => {
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "del";
			
			frm.submit();
		})
		
		// 수정
		let modBtn = document.getElementById('modBtn');
		modBtn.addEventListener('click', () => {
			let frm = document.forms.frm;
			frm.method = "post";
			frm.cmd.value = "mod";
			
			frm.submit();
		});
		
	</script>
</body>
</html>