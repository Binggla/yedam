<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<div id="divList"></div>
	<script>
		$.ajax({
			url: 'req',
			method: 'post',
			async: false,
			data: JSON.stringify({first_name:'subin', last_name:'kim'}),
			contentType : 'application/json; charset=utf-8',
			dataType: 'json',
			success: ajaxEmpSelect
		})
		
		function ajaxEmpSelect(result) {
			result
		}
		
	</script>
</body>
</html>