// array/basic1.js

// reduce(callbackFunction[, initialValue(초기값)]) : 배열의 각 요소를 순회하며 callback함수의 실행 값을 누적하여 하나의 결과값을 반환
// accumulator, currentValue, index, array 네 가지 인수를 갖는다.
// accummulator : 콜백함수의 반환값을 누적하는 인수. 초기값을 통해 타입 설정 가능.
// 초기값을 제공하지 않을경우 배열의 첫 번째 요소를 사용하고, 빈 배열에서 초기값이 없을 경우 에러가 발생한다. 

const numbers = [23, 4, 77, 51, 63, 34, 62, 92];

let result = numbers.reduce(function(accum, val, idx, ary){
  console.log(accum, val, idx, ary);
  return accum += val;
}, 0);
 
console.log(result);   // 406

// reduce()로 map() 구현 ; 배열 요소의 2배의 값을 가지는 배열 출력.
result = numbers.reduce(function(accum, val) {
  accum.push(val * 2);
  return accum;
}, []);
console.log(result);   // [46, 8, 154, 102, 126, 68, 124, 184]

// reduce()로 filter() 구현 ; 50보다 큰 숫자를 가지는 배열 출력.
// reduceRight() : 배열의 끝에서부터 시작
result = numbers.reduceRight(function (accum, val) {
  if (val >= 50) {
    accum.push(val);
  }
  return accum;
}, []);

console.log(result);   // [92, 62, 63, 51, 77]