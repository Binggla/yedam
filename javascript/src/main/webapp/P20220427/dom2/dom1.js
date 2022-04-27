
let data = [{studNo: 101, studName: '지수빈', korScore: 100, engScore: 100},
            {studNo: 102, studName: '나현주', korScore: 100, engScore: 100},
            {studNo: 103, studName: '이유빈', korScore: 100, engScore: 100},
            {studNo: 104, studName: '유해정', korScore: 100, engScore: 100},
            {studNo: 105, studName: '권가희', korScore: 100, engScore: 100}];

// 초기화
let list = document.getElementById('list');
data.forEach(function(elem, idx, ary){
  list.appendChild(makeTr(elem));
});

// 변경 버튼 이벤트
let changeBtn = document.querySelector('input[type="button"]');
changeBtn.addEventListener('click', function(e){
  let targetTr = document.querySelectorAll('#list>tr');
  console.log(targetTr);
  let sno = document.getElementById('studNo').value;
  let skor = document.getElementById('korScore').value;
  let seng = document.getElementById('engScore').value;
  targetTr.forEach(function(tr) {
    if (tr.children[0].innerHTML == sno) {
      tr.children[2].innerHTML = skor;
    }
  });

});

// 대상 찾아오기

// 변경 메소드
function changeCallBack1(e) {
  e.preventDefault(); // 기본 기능 차단
  let sno = document.getElementById('studNo').value;
  let sname = document.getElementById('studName').value;
  let skor = document.getElementById('korScore').value;
  let seng = document.getElementById('engScore').value;
  if (!(sno || sname || skor || seng)) {
    alert('필수 값을 입력하세요.');
    return;
  }
  // } else {
  //   if (!sno) {
  //     alert('변경할 아이디를 입력하세요. ');
  //     return;
  //   } else if (!sname) {
  //     alert('변경할 이름을 입력하세요. ');
  //     return;
  //   } else if (!skor) {
  //     alert('변경할 국어 점수를 입력하세요. ');
  //     return;
  //   } else if (!seng) {
  //     alert('변경할 영어 점수를 입력하세요. ');
  //     return;
  //   }
  // }

  let searchTr = document.getElementById(`sno_${sno}`);
  searchTr.children[1].innerHTML = sname;
  searchTr.children[2].innerHTML = skor;
  searchTr.children[3].innerHTML = seng;
}

// tr 반환 함수
function makeTr(student) {
  let tr = document.createElement('tr');
  tr.setAttribute('id', 'sno_' + student.studNo);

  tr.addEventListener('click', function(e){
    // console.log(e.target); // <td></td> 한 줄 즉, 가장 하위 요소만 선택
    // console.log(this);        // <tr></tr> 전체

   let fields = [];
    for (field in student) {
      fields.push(field);
    }
    for (let i=0; i<fields.length; i++) {
      document.getElementById(fields[i]).value =  this.children[i].innerHTML;
    }

  });

  for(let field in student) {
    let td = document.createElement('td');
    let text = document.createTextNode(student[field]);
    td.appendChild(text);
    tr.appendChild(td);

  }
  
  // 기능 속성에 삭제 버튼 만들기
  let td = document.createElement('td');
  let btn = document.createElement('button');
  text = document.createTextNode('삭제');
  btn.appendChild(text);
  btn.addEventListener('click', function(e){
    e.stopPropagation(); // stopPropagation() : 상위로의 이벤트 전파 차단하는 함수.
    // console.log(this);
    e.target.parentElement.parentElement.remove();
  }, true);
  td.appendChild(btn);
  tr.appendChild(td);

  return tr;
}
