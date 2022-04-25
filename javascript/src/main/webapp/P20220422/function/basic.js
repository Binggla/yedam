// basic.js


// 1. 함수 선언식으로 함수 선언하기
// function 함수이름 (파라메터) { 
//    실행영역
// }
function sum(num1, num2) { // === let sum = fuction (num1, num2) {
  console.log(num1, num2);
  return num1+num2;
}
let result = sum(10, 20); // 30
console.log(`결과는 ${result}입니다.`)


// 2. 함수 표현식으로 함수 선언하기
// let 함수이름 = function (파라메터) { 
//    실행영역
// }
let myfnc = function (val1, val2) {
  var myVal = 10;
  return val1 + val2 + myVal;
}
console.log(typeof myfnc, myfnc);
// --> function 타입
// --> ƒ (val1, val2) {
//          var myVal = 10;
//          return val1 + val2 + myVal;
//       }

result = myfnc(10, 20);
console.log(result);  // 40


// 1번에 선언된 function은 sum이라고 하는 변수에 sum함수를 담은 것으로 인식되므로 같은 이름의 변수를 재선언하는 것은 불가능.
// let sum = myfnc; // Error : Uncaught SyntaxError: Identifier 'sum' has already been declared

// funcion은 참조 타입으로 mysum과 myfnc는 같은 주소값을 참조한다.
let mysum = myfnc;
result = mysum(20, 30);
console.log(result);   // 60


const person = {
  fullName: 'Jee',
  age: 20,
  height: 175.3
}

const person1 = {
  fullName: 'Su',
  age: 27,
  height: 169.0
}

const person2 = {
  fullName: 'Bin',
  age: 23,
  height: 187.3
}

let myinfo = function (obj) {
  var info = `${obj.fullName}은(는) ${obj.age}살이고, 키는 ${obj.height}cm입니다.`
  return info;
}

const persons = [person, person1, person2];
for (let person of persons) {
  let result = myinfo(person);
  console.log(result);
}
// Jee은(는) 20살이고, 키는 175.3cm입니다.
// Su은(는) 27살이고, 키는 169cm입니다.
// Bin은(는) 23살이고, 키는 187.3cm입니다.

console.clear();


// 자바스크립트에서 사용 가능한 매개변수 : 문자열, 숫자, 불리언, 배열, 함수
// 메소드의 매개값으로 사용되는 함수 === 콜백 함수

persons.forEach(function (val, ind, ary){
  console.log(val, ind, ary);
  console.log(myinfo(val));
});
      // forEach() : 오직 array 객체에 활용이 가능한 메서드로, 파라미터로 주어진 함수를 배열 요소 각각에 대해 실행하는 메서드이다. map() 메서드와 거의 비슷하지만 차이점은 따로 return 하는 값이 없다.
      // 첫 번째 인수는 value, 두 번째 인수는 index, 세 번째 인수는 array

// console.clear();

let funcParam = function (val, ind, ary) {
  console.log(`요소: ${val.fullName}, 인덱스: ${ind}`);
  console.log(ary);
}

persons.forEach(funcParam);

// 화살표 함수 (람다식과 비슷)
// 매개변수가 하나뿐인 경우 괄호는 선택사항 : 파라미터가 하나만 있을 때는 괄호를 생략할 수 있다. 하지만 매개변수가 없는 함수는 괄호가 필요
// 화살표 함수의 유일한 문장이 'return'일 때 'return'과 중괄호({})를 생략할 수 있다.
funcParam = (val, ind) => console.log(`요소: ${val.fullName}, 인덱스: ${ind}`);
