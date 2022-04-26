// dom/practice2.js

document.addEventListener('DOMContentLoaded', callbackFnc);

function callbackFnc() {

  let persons = [{id:'101', name:'홍길동', age:20}, {id:'102', name:'김길동', age:22}, {id:'103', name:'지길동', age:25}];
  let tableTag = document.createElement('table');
  tableTag.setAttribute('border', 1);

  let thead = makeHead(persons);
  tableTag.appendChild(thead);

  let tbody = makeBody(persons);
  tableTag.appendChild(tbody);
    
document.getElementById('show').appendChild(tableTag);

// 요소 추가!
let newObj = {id:104, name:'김민수', age:30};
console.log(makeTr(newObj)); // <tr id="104"><td>김민수</td><td>30살</td></tr>
document.querySelector('table>tbody').appendChild(makeTr(newObj));

// 추가 버튼 이벤트
let btn = document.querySelector('button');
btn.addEventListener('click', function() {
  let obj = {}

  let userName = document.getElementById('userName').value; // id값이 userName인 요소의 value값을 userName에 저장
  let userAge = document.getElementById('userAge').value;

  obj.name = userName; // userName을 obj 객체의 name 속성에 저장
  obj.age = userAge;
  obj.id = 110;

  document.querySelector('table>tbody').appendChild(makeTr(obj));
  // 모든 속성이 추가된 객체를 makeTr함수를 통해 tr요소에 추가한 후 tbody 자식으로 추가.
});

}


function makeHead(objAry) {

  let theadTag = document.createElement('thead');
    
      let trTag = document.createElement('tr');
      
        let thTag = document.createElement('th');
        let text = document.createTextNode('이름');
        thTag.appendChild(text);
        trTag.appendChild(thTag);
        
        thTag = document.createElement('th');
        text = document.createTextNode('나이');
        thTag.appendChild(text);
        trTag.appendChild(thTag);

        thTag = document.createElement('th');
        text = document.createTextNode('기능');
        thTag.appendChild(text);
        trTag.appendChild(thTag);
      
      theadTag.appendChild(trTag);
        
  return theadTag;
}

function makeBody(objAry) {

  let tbodyTag = document.createElement('tbody');

  objAry.forEach(function(obj) {
    tbodyTag.appendChild(makeTr(obj));
  });
    
  
  return tbodyTag;
}

function makeTr(obj) {

  let trTag = document.createElement('tr');
  trTag.setAttribute('id', obj.id);

  let fields = ['name', 'age'];
    
  fields.forEach(function(field) {
    let tdTag = document.createElement('td');
    let tdName = document.createTextNode(obj[field] + `${field=="age"?"살":""}`);
    tdTag.appendChild(tdName);
    trTag.appendChild(tdTag);
  });

  let btn = document.createElement('button');
  btn.innerHTML = '삭제';

  // addEventListener() : 지정한 유형의 이벤트를 대상이 수신할 때마다 호출할 함수를 설정한다.
  // addEventListener(type, listener);
  // type 수신할 이벤트 유형을 나타내는 대소문자 구분 문자열입니다.
  // listener 지정한 이벤트(Event 인터페이스를 구현한 객체)를 수신할 객체입니다. EventListener 인터페이스를 구현하는 객체거나, JavaScript 함수여야 합니다.
  btn.addEventListener('click', deleteCallBack);

  let tdTag = document.createElement('td');
  tdTag.appendChild(btn);
  trTag.appendChild(tdTag);

  return trTag;

}

function deleteCallBack() {
  
  // evnt.target.parentElement.parentElement.remove()
  // .target: 이벤트가 발생하는 대상 = button
  // .parentElement: 조상 요소 = td
  // .parentElement: 조상 요소 = tr
  // .remove(): 삭제

   // 부모로부터 하위 요소들로 내려오기
      // console.log(window); 
      // console.log(window.document.children); // html
      // console.log(window.document.children[0].children); // head, body
      // console.log(window.document.children[0].children[1].children[0]) // h3
      // window.document.children[0].children[1].children[0].innerHTML = '요기요';

      // 자식으로부터 상위 요소들로 올라가기
      // let h3 = window.document.children[0].children[1].children[0];
      // let newH3 = h3.parentElement.appendChild(document.createElement('h1'));
      // newH3.innerHTML ='여기요';

      // addEvnetListener()에서 this는 event.target을 의미한다.
      console.log(this);  // event.target
      this.parentElement.parentElement.remove();

}