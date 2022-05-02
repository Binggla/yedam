<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax.jsp</title>
</head>
<body>
	<script>
		let url = 'StudentGetServlet'; // default가 get 방식
		fetch(url)
				.then(result => {
					console.log(result);
					return result.json();	// StudentGetServlet의 response를 json 형태의 데이터로 만들기.
				})
				.then(result => {
					console.log(result);
				})
				.catch(error => {
					console.log(error);
				});
	</script>
</body>
</html>