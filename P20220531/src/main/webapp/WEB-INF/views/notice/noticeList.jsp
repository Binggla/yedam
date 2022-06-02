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
				<button type="button" onclick="ajaxSearchList();">검색</button>
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
							<tr>
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
	
<!-- function -->
<script type="text/javascript">

	function ajaxSearchList() {
		let formData = new FormData(frm);
		
		fetch('ajaxSearchList.do', {
			method: 'POST',
			body: formData
		})
			.then(response => response.json())
			.then(result => {
				document.querySelector('tbody').remove();
				makeTbody(result);
			})
	}

	function makeTbody(result) {
		let table = document.getElementById('tb');
		let tbody = document.createElement('tbody');

		result.forEach(function(notice) {
			let tr = makeTr(notice);
			tbody.appendChild(tr);
		})
		
		table.appendChild(tbody);
	}
	
	function makeTr(notice) {
	
		let tr = document.createElement('tr');
		for(let col in notice) {
			console.log(col)
			if(col != 'noticeContents' && col != 'noticeDir') {
				let td = document.createElement('td');
				td.innerHTML = notice[col];
				
				if(col == 'noticeAttech') {
					if(!notice[col]) {
						td.innerHTML = '';
					}
				}
				
				tr.appendChild(td);
				
			}
		}
		return tr;
	}

</script>

<!-- 이벤트 -->
<script>

 	let list = document.querySelector('tbody');
 	list.addEventListener('click', function(e) {
 		if(e.target.tagName === 'TD') {
 			// GET 방식
 			// location.href='getContent.do?noticeId='+e.target.parentNode.children[0].textContent;
 			
 			// POST 방식
 			frm2.noticeId.value = e.target.parentNode.children[0].textContent;
 			frm2.action = 'getContent.do';
 			frm2.submit();
 		}
		
 	})
</script>
</body>
</html>