// reference.js (참조 타입)

// 배열 선언 
const names = ['조수연', '황진주', '권가희', '이유빈'];
for (let i = 0; i < names.length; i++) {
  console.log((i+1) + '번째 이름 : ' + names[i]);
}

// enhanced for (향상된 for문)
// 자바의 for(String name : names) {}
for (let name of names) {
  console.log(name);
}

const numbers = [23, 44, 38, 12, 56];
for (let num of numbers) {
  if (num > 40) {
    console.log(num);
  }
}

// 값을 입력 받아서 배열에 저장하기
// prompt : 입력값 받기
// const inputs = [];
// for (let i = 0; i < numbers.length; i++) {
//   var inputVal = prompt('값을 입력하세요...');
//   console.log(typeof inputVal, inputVal);
//   inputs[i] = inputVal;
// }

// 5개의 값을 입력 받아서 합계, 평균 구하기

const inputNums = [];

for (let i = 0; i < 5; i++) {
  var inputVal = prompt('값을 입력하세요. (' + (i+1) + '/5)')
  console.log(typeof inputVal, inputVal);
  inputNums[i] = parseInt(inputVal);
}

let sum, avg = 0;
for (let n of inputNums) {
  sum = sum + n;
}
avg = sum / 5;

console.log('합계 : ' + sum + ', 평균 : ' + avg)