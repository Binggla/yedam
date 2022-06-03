<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		table tr:hover{
			cursor:pointer;
			background:gray;
		}
	</style>
</head>
<body>
	<div align="center">
		<div><h1>공지사항</h1></div>
		<div>
			<form id="frm">
				<select id="state" name="state">
					<option value="1">전체</option>
					<option value="2">작성자</option>
					<option value="3">제목</option>
					<option value="4">내용</option>
				</select>&nbsp;
				<input id="key" name="key" type="text" placeholder="검색어 입력">&nbsp;
				<button type="button" onclick="searchList();">검색</button>
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
							<tr onclick="getContent(${n.noticeId });">
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
			<form id="frm2" action="" method="post">
				<input type="hidden" id="noticeId" name="noticeId">
			</form>
		</div><br/>
		<div>
			<button type="button" onclick="location.href='noticeInsertForm.do'">글 등록</button>
		</div>
	</div>
	
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">

	// jQuery
	function searchList() {
		let state = $("#state").val();
		let key = $("#key").val();
		
		$.ajax({
			url : "ajaxSearchList.do",
			type : "post",
			data : {"state" : state, "key" : key},
			dataType : "json",
			success : function(data) {
				let tbody = $("tbody");
				tbody.text('');
				$.each(data, function(index, n) {	// n = 한 행의 변수명
					var row = $("<tr onclick='getContent("+n.noticeId+");'/>").append(
							$("<td/>").text(n.noticeId),
							$("<td/>").text(n.noticeName),
							$("<td/>").text(n.noticeTitle),
							$("<td/>").text(n.noticeDate),
							$("<td/>").text(n.noticeHit),
							$("<td/>").text(n.noticeAttech)
						);
					tbody.append(row);
				})
				$("#tb").append(tbody);
			},
			error : function() {
				alert('의도치 않는 오류가 발생했습니다.');
			}
		})
	
	}
	
	function ajaxSearchList() {
		let formData = new FormData(frm);
		
		fetch('ajaxSearchList.do', {
			method: 'POST',
			body: formData
		})
			.then(response => response.json())
			.then(data => {
				changeTbody(data);
			})
	}

	function changeTbody(noticeAry) {
 		let tbody = document.querySelector('tbody');
 		tbody.innerHTML = '';

 		noticeAry.forEach(function(notice) {
 			let tr = makeTr(notice);
 			tbody.appendChild(tr);
 		})
	}
	
	function makeTr(data) {
	
		let keyAry = ['noticeId', 'noticeName', 'noticeTitle', 'noticeDate', 'noticeHit', 'noticeAttech'];
		let tr = document.createElement('tr');
		
		for(let key of keyAry) {
			let td = document.createElement('td');
			td.innerHTML = data[key];
			tr.appendChild(td);
		}
		
		return tr;
	}

	// 이벤트
	function getContent(noticeId) {
		// GET 방식
		// location.href='getContent.do?noticeId='+e.target.parentNode.children[0].textContent;
		
		// POST 방식
		frm2.noticeId.value = noticeId;
		frm2.action = 'getContent.do';
		frm2.submit();
	
}
		
</script>
</body>
</html>