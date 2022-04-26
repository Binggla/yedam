// dom/basic2.js

document.addEventListener('DOMContentLoaded', function() {
  let divTag = document.createElement('div');

  let spanName = document.createElement('span');
  let name = document.createTextNode('홍길동'); // '홍길동' Text Node 생성
  spanName.appendChild(name);  // '홍길동' Text Node를 span 태그의 자식으로 넣는다. 
  // <span>홍길동</span>
  spanName.setAttribute('id', 'name'); // 'id="name"' Attribute node 생성하여 추가
  // <span id="name">홍길동</span>
  let hypen = document.createTextNode(' - ');
  let spanAge = document.createElement('span');
  let age = document.createTextNode('20살'); // '20살' Text Node 생성
  spanAge.appendChild(age);  // '20살' Text Node를 span 태그의 자식으로 넣는다. 
  // <span>20살</span>
  spanAge.setAttribute('class', 'age'); // class="age" Attribute node 생성하여 추가
  // <span class="age">20살</span>

  divTag.appendChild(spanName);   // <div><span>홍길동</span></div>
  divTag.appendChild(hypen);      // <div><span>홍길동</span> - </div>
  divTag.appendChild(spanAge);    // <div><span>홍길동</span> - <span>20살</span></div>

  document.getElementById('show').appendChild(divTag);
});


// DOM 노드
// Element_node : <body>, <a>, <div> , <style>, <script>, <h1>, <span> ...
// Attrivute_node : id="myelement", class"align-right", width='300' ...
// Text_node : 텍스트 문자열 노드, HTML 페이지 안의 모든 텍스트