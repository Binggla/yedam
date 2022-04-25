// string/basic.js

let str1 = '문자열';
console.log(typeof str1); // string

let str2 = new String('문자열');
console.log(typeof str2); // object


// 비교 연산자 == : 값 비교 & 비교 연산자 === : 값과 타입을 비교
console.log(str1 == str2); // true
console.log(str1 === str2); // false


// slice(), substring(), substr() : 인덱스 값을 기준으로 문자열 잘라내기
// slice(start, end-1)
// substring()과의 차이점 - 음수 사용 가능
let result = '안녕하세요. 반갑습니다.'.slice(0, 5);
console.log(result); // 안녕하세요
result = '안녕하세요. 반갑습니다.'.slice(3); // 3~끝까지
console.log(result); // 세요. 반갑습니다.
result = '안녕하세요. 반갑습니다.'.slice(-6); // -6~끝까지
console.log(result); // 반갑습니다.
// substring(start, end)
result = str1.substring(2); // index 0번 ~ 2번 잘라내기
console.log(result);
// substr(start, length) -> Deprecated 
result = str2.substr(1, 2); // index 0 크기 1 잘라내기
console.log(result);


const cal1 = '1 + 2 * 3'; // string
const cal2 = new String('1 + 2 * 3'); // object

// eval() : 문자열을 수식으로 변경.
console.log(eval(cal1)); // 7
// valueOf() 함수로 객체 타입을 문자열 타입으로 변경한 후 eval() 함수로 문자열 타입을 수식으로 변경.
console.log(eval(cal2)); // String {'1 + 2 * 3'}
console.log(eval(cal2.valueOf())); // 7


// trim() : 문자열의 좌우 여백을 잘라낸다.
// trimStart() : 문자열의 왼쪽 여백을 잘라낸다.
// trimEnd() : 문자열의 오른쪽 여백을 잘라낸다.
console.log(' 문자열 공백 테스트 '.trim());
console.log(' 문자열 공백 테스트 '.trimStart());
console.log(' 문자열 공백 테스트 '.trimStart().trimEnd());


// 문자열 사이의 공백 제거하기.
// split() : 매개값을 기준으로 문장을 자른다.
result = ' 문자열 공백 테스트 '.split(' ');
console.log(result); // (5) ['', '문자열', '공백', '테스트', '']

// filter() : 배열에 사용되는 함수로, 매개값으로 들어오는 함수의 조건을 만족하는 값(true)들로 구성된 새로운 배열을 반환한다. forEach(), map()과 동일하게 value, index, array로 구성되어져 있다.
result = result.filter(function(val) {
  return val; 
}); 
console.log(result); // (3) ['문자열', '공백', '테스트'] 
    // JS에서 null, '', 0, undefined는 false 값으로, filter()에서 걸러진다.
    // null -> false로 인식되므로 아래와 같이 if문에 사용 가능하다.
    if (!null) { 
      console.log('null은 false입니다.');
    }

// join() : 문자열 배열을 문자열로 변환. 매개값으로 들어온 값을 인덱스 사이에 반환한다.
console.log(result.join('')) // 문자열공백테스트


// 위 문장들을 한 문장으로 입력하기.
result = ' 문자열 공백 테스트 '.split(' ').filter(val => val).join(',');
console.log(result);


// toString() : 문자열로 변환.
let num1 = 123;
console.log(typeof num1); // number
num1 = num1.toString();
console.log(typeof num1); // string
// true 값을 문자열로 바꿀 수 있다.
result = true.toString(); 
console.log(result); // true

let obj = {
  key: 'Jee',
  value: 15
}
console.log(obj.toString()); // 객체는 문자열로 변환할 수 없다.
console.log(obj.key.toString());
console.log(obj.value.toString());