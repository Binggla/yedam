// array/basic.js

// 배열 선언 : [], new Array();
let ary = [1, 2];

// push() : 배열의 마지막에 값 추가
// unshift() : 배열의 처음에 값 추가
ary.push(3);
console.log(ary.toString());  // 1,2,3
ary.unshift(0);
console.log(ary.toString());  // 0,1,2,3

// pop() : 배열의 마지막 값 삭제
// shift() : 배열의 처음 값 삭제
ary.pop();
ary.shift();
console.log(ary.toString());  // 1,2


// forEach() 함수로 배열에 값 넣기
let newAry = [3, 4, 5, 6];

newAry.forEach(function(num) {
  ary.push(num);
});
console.log(ary.toString());  // 1,2,3,4,5,6
newAry.forEach(function(num) {
  ary.unshift(num);
});
console.log(ary.toString());  // 6,5,4,3,1,2,3,4,5,6
ary.shift();
ary.shift();
ary.shift();  // 3,1,2,3,4,5,6


// splice(위치, 삭제할 길이, 대체값1, 대체값2 ...) : 추가, 수정, 삭제
ary.splice(0, 1, 2);  
console.log(ary.toString());  // 2,1,2,3,4,5,6
ary.splice(0, 1);  
console.log(ary.toString());  // 1,2,3,4,5,6

newAry.forEach(function(num) {
  ary.splice(2, 0, num);
});
console.log(ary.toString());  // 1,2,6,5,4,3,3,4,5,6


let names = [];
let anonym = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus aut illum';

anonym.split(' ').forEach(function(val) {
  names.push(val);
});

console.log(names.toString());  // Lorem,ipsum,dolor,sit,amet,consectetur,adipisicing,elit.,Voluptatibus,aut,illum
console.log(names);  // ['Lorem', 'ipsum', 'dolor', 'sit', 'amet', 'consectetur', 'adipisicing', 'elit.', 'Voluptatibus', 'aut', 'illum']


// map()을 이용하여 mapping 작업하기
// return값이 없는 forEach()와 다르게 map()은 배열을 반환해준다.
let result = names.map(function(val) {
  return val.toUpperCase();
});
console.log(result); // ['LOREM', 'IPSUM', 'DOLOR', 'SIT', 'AMET', 'CONSECTETUR', 'ADIPISICING', 'ELIT.', 'VOLUPTATIBUS', 'AUT', 'ILLUM']

result = result.filter(function(val) {
  return val.length >= 10;
});
console.log(result);  // ['CONSECTETUR', 'ADIPISICING', 'VOLUPTATIBUS']

// chain rules
result = names//
.map(val => val.toUpperCase())//
.filter(val => val.length >= 10);
console.log(result);  // ['CONSECTETUR', 'ADIPISICING', 'VOLUPTATIBUS']