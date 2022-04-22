// variable.js

var myName = '지수빈';  // string
// var yourName;              // undefined
myName = 100;            // number
myName = true;           // boolean
myName = null;           // object
 
console.log(typeof yourName);
// typeof : 타입 체크

var yourName = "홍길동";
// '' "" : 모두 문자열로 인식한다.
// 변수가 console 이후에 선언되어도 console은 알아챈다. why? 자바스크립트가 전체 페이지에서 선언된 변수 모두를 먼저 체크하기 때문. = 변수 호이스팅(Hoisting)
// 호이스팅 : var로 함수 안의 코드 중간에 선언된 변수들은 런타임 시점에 함수 맨 위로 선언이 이동한다.

var yourName = "수빈";
// 변수 타입을 2번 선언하여도 에러가 나지 않는다.


// 전역변수 / 지역변수 ---------------------------------------------------------------------

// 전역변수 : 스크립트에서 선언되는 변수
function checkInfo() {
  myName = 'JeeSubin';
  console.log(myName);    // JeeSubin
}
checkInfo();
console.log(myName);      // JeeSubin

// 지역변수 : 함수 내부에서 선언되는 변수
function checkInfo() {
  var myName = 'JeeSubin';
  console.log(myName);    // JeeSubin
}
checkInfo();
console.log(myName);      // null


// let, const ----------------------------------------------------------------------------
// ES6 (ES2015)부터 let, const 선언자가 생겼다.
// 변수 타입을 2번 선언하지 않아도 에러가 나지 않는 점이 프로그래밍에 유연성을 주었으나, 프로그램 크기가 커진다는 단점과 변수가 중복 선언될 위험성이 있다. let은 중복 선언이 불가능하다.

let letName = 'Binggla';
console.log(letName);  // Binggla

// 1. let 변수 타입 재선언
// let myName = 'Subb';   
// 이미 변수가 선언되었다는 에러 메시지 (중복 불가) 
// Uncaught SyntaxError: Identifier 'myName' has already been declared (at variable.js:44:5)

// 2. let 변수에 재할당은 가능.
letName = 'Subb';
console.log(letName);  // Subb

// 3. let 지역 변수 선언
function info() {
  let letName = 'Jeee';
  console.log(letName); // Jeee
}
info();
console.log(letName);   // Subb

// 4. let 변수 블록 레벨 선언
{
  let letName = 'Binggla';
  console.log(letName);  // Binggla
}

{
  let letName = 'Gla';
  console.log(letName);   // Gla
}

console.log(letName);   // Subb

// const : 상수 선언
const otherName = 'Binggla';
// otherName = 'Gla';
// Uncaught TypeError: Assignment to constant variable. at variable.js:78:11