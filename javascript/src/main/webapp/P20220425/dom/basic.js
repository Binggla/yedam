// dom/basic.js

// DOM(Document Object Model, 문서 객체 모델)
// HTML 또는 XML 페이지의 구조와 요소들을 제어할 수 있도록 제공하는 프로그래밍 인터페이스, 또는 구조화된 데이터.
// HTML파일을 읽어 문서의 구조를 파악한 다음 트리 형태로 된 데이터 구조를 만든다. 이것을 DOM이라고 부른다. 웹 브라우저가 웹 페이지를 화면에 표시하는 단계로 넘어가기 전에 JS가 DOM을 제어할 수 있다. 
// 제어가 끝나면 웹 브라우저가 DOM 구조를 기반으로 웹페이지를 그리는 과정을 진행한다. 이를 렌더링(Rendering)이라고 한다. 렌더링


// addEventListerner('이벤트이름', '이벤트핸들러(실행코드)')
// DOMContentLoaded : DOM 컨텐츠가 모두 로딩이 된 후

console.log('1');

document.addEventListener('DOMContentLoaded', function() {
  console.log('2');

  // Tag 이름으로 선택하기
  let h3Tags = document.getElementsByTagName('h3'); // HTMLCollection
  console.log(h3Tags);
  // 몇 번째 h3인지 선택하여 변경하여야 한다.
  h3Tags[1].innerHTML = 'JavaScript!';

  // id값으로 선택하기
  let idFirst = document.getElementById('first'); // element
  console.log(idFirst);
  idFirst.innerHTML = 'Hello!';

  // class값으로 선택하기
  let classFirst = document.getElementsByClassName('first');  // HTMLCollection
  console.log(classFirst);
  classFirst[0].innerHTML = '사과';

  // css 선택자 ; h3 > div 선택하기
  let list = document.querySelectorAll('ul>li');
  console.log(list);
  list[0].style.background = 'yellow';


  // DOM 생성 (li)
  let newList = document.createElement('li'); 
  newList.innerHTML = 'Mango';
  console.log(newList); // <li>Mango</li>

  // ul 하위요소로 newList 추가하기
  let ulTag = document.querySelector('ul');
  ulTag.appendChild(newList);
  
});

console.log('3');