// practice.js

const numbers = [23, 45, 32, 55, 34, 72];

// 향상된 for문 이용
let sum = 0;
let evenSum = function (numAry) {
  for (let num of numAry) {
    if (num % 2 === 0) {
      sum += num;
    }
  }
}

evenSum(numbers);
console.log(`짝수의 합 : ${sum}`);

// 화살표 함수 / forEach() 함수 이용
sum = 0;
evenSum = (num) => {
  if (num%2 === 0) { sum += num; }
}

numbers.forEach(evenSum);
console.log(`짝수의 합 : ${sum}`);

// 콜백 함수 이용
sum = 0;
numbers.forEach((num) => {
  if (num%2 === 0) { sum += num; }
});
console.log(`짝수의 합 : ${sum}`);

