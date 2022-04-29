// ajax/post.js

document.addEventListener('DOMContentLoaded', init);

// 리스트
function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json')	// ajax 경로로 이동하여 studentList.json 불러오기(StudentListService.java)
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
		let tbodyList = document.getElementById('list');
		data.forEach(function(elem) {
			tbodyList.appendChild(makeTr(elem));
		});
	} // end of onload
	

	let modBtn = document.querySelector('input[type=button]');
	modBtn.addEventListener('click', function() {
		
		let no = document.querySelector('input[name=studNo]').value;
		let name = document.querySelector('input[name=studName]').value;
		let eng = document.querySelector('input[name=eScore]').value;
		let kor = document.querySelector('input[name=kScore]').value;


		let xhtp = new XMLHttpRequest();
		xhtp.open('get', `modStudServlet?a=${no}&b=${name}&c=${eng}&d=${kor}`);
		xhtp.send();
		xhtp.onload = function() {
			console.log(xhtp.responseText);
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				let obj = {
					studentNo: result.studentNo,
					studentName: result.studentName,
					engScore: result.engScore,
					korScore: result.korScore
				}
				let newTr = makeTr(obj);
				let oldTr = document.getElementById(result.studentNo);
				alert(result.studentNo+'의 변경이 완료되었습니다.');
				document.getElementById('list').replaceChild(newTr, oldTr);

			} else {
				alert('처리 중 에러 발생');
			}
		}

	});

} // end of init()

// 학생 정보 수정.
function modStudent() {

}
// end of modStudent()

// 한건 추가.
function addStudent(e) {
	e.preventDefault(); // 기본 submit 기능 차단
	console.log(e)

	let no = document.querySelector('input[name="studNo"]').value;
	let name = document.querySelector('input[name="studName"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;

	// 서버에 파일을 요청하고 읽어들여보자.	
	let xhtp = new XMLHttpRequest(); // 비동기방식으로 서버에 파일 요청.
	xhtp.open('get', `addStudServlet?studNo=${no}&studName=${name}&eScore=${eng}&kScore=${kor}`);  // 파일을 요청할 페이지 지정.
	xhtp.send();  // 호출 시작.
	xhtp.onload = function() {
		console.log(xhtp.responseText);
		let result = JSON.parse(xhtp.responseText);
		if (result.retCode == 'Success') {
			// successCallBack();
			successCallBack2(result); // result = {retCode:?, studNo:?, studName:?, eScore:?, Kscore:?}
		} else if (result.retCode == 'Fail') {
			failCallBack();
		}
	}; // end of function()
} // end of addStudent(e)


// tr 반환 함수
function makeTr(student) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', student.studentNo); // tr의 id값을 studentNo로 지정하고, id값을 통해 라인을 삭제하자.

	for (field in student) {
		let td = document.createElement('td');
		td.innerHTML = student[field];
		tr.appendChild(td);
	}

	// 삭제 버튼 생성.
	let delBtn = document.createElement('button');
	delBtn.innerHTML = '삭제';
	let td = document.createElement('td');
	td.appendChild(delBtn);
	tr.appendChild(td);

	// 삭제 이벤트 등록.
	delBtn.addEventListener('click', function() {
		// 삭제 ID 파악 -> AJAX(XMLHttpRequest()) 호츨
		let id = this.parentElement.parentElement.firstChild.innerHTML;
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'delStudServlet?delId=' + id);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				alert(result.retVal + "번이 삭제되었습니다.")
				document.getElementById(result.retVal).remove();
			} else {
				console.log(result.retVal);
			}
		}

	});

	return tr;
} // end of makeTr()


function successCallBack2(jsonResult) {
	// console.log(jsonResult);
	let obj = {
		studentNo: jsonResult.studentNo,
		studentName: jsonResult.studentName,
		engScore: jsonResult.engScore,
		korScore: jsonResult.korScore
	}
	document.getElementById('list').appendChild(makeTr(obj));

} // end of successCallBack2()

function failCallBack() {
	alert('처리 중 에러 발생');
}

function successCallBack() {
	// 사용자 입력값을 id='list' 하위에 추가.
	let no = document.querySelector('input[name="studNo"]').value; // 106
	let name = document.querySelector('input[name="studName"]').value; // 지수빈
	let eng = document.querySelector('input[name="eScore"]').value; // 46
	let kor = document.querySelector('input[name="kScore"]').value; // 86

	let stud = {
		studNo: no,
		studName: name,
		eScore: eng,
		kScore: kor
	}

	let row = makeTr(stud);

	document.getElementById('list').appendChild(row);
} // end of successCallBack()