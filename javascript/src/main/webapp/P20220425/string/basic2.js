// string/basic2.js

// indexOf(string, index) : 찾고자하는 문자열의 첫 번째 위치 값을 반환한다. 값을 찾지 못하면 -1을 반환한다. 위치 값을 함께 입력하면 해당 위치부터 검색한다.
let str = '안녕하세요. 지수빈입니다.';
console.log(str.indexOf('지수빈')); // 7
console.log(str.indexOf('지수반')); // -1

str = '안녕하세요. 지수빈입니다. 카페인과 한몸인 지수빈입니다.';
console.log(str.indexOf('지수빈', 10)) // 24

str = '안녕하세요. 지수빈입니다. 카페인과 한몸인 지수빈입니다. 알코올을 섭취하고 싶은 지수빈입니다.';
let position = str.indexOf('알코올');
result = str.indexOf('지수빈', position) // 알코올 지수빈을 검색
console.log(result); // 45


// lastIndexOf() : 찾고자하는 문자열의 마지막 위치 값을 반환한다.
str = '안녕하세요. 지수빈입니다. 카페인과 한몸인 지수빈입니다. 알코올을 섭취하고 싶은 지수빈입니다.';
console.log(str.lastIndexOf('지수빈')); // 45


// includes(string) : 찾을 문자열에 대한 true/false 값을 반환한다.
result = str.includes('지수반');
console.log(result); // false


// charAt(index) : 입력한 위치 값의 문자를 반환.
let str2 = str.charAt(20);
console.log(str2); // 한


// toLowerCase(), toUpperCase()
let str3 = 'Lorem ipsum DOLOR sit amet';
console.log(str3.toUpperCase()); // LOREM IPSUM DOLOR SIT AMET
console.log(str3.toLowerCase()); // lorem ipsum dolor sit amet


console.clear();
// search(string & 정규표현식) : 찾을 문자열의 인덱스 값을 반환한다. 해당 문자열이 없으면 -1을 반환한다.
result = str3.search('dolor'); 
console.log(result); // -1
result = str3.toUpperCase().search('DOLOR'); 
console.log(result); // 12
result = str3.search(/dolor/i);
console.log(result); // 12

    // JavaScript Regular Expressions(정규표현식) / / 
    //    정규표현식 문자열로 생성 : /pattern/modifiers 
    //    RegExp 객체로 생성   : new RegExp(pattern & RegExp 객체, flags)

    // modifier(수정자)
    // i : 문자열에서 대소문자를 구분하지 않는다.
    // g : 문자열 전체를 확인한다.
    // m : 문자열 `^` , `$`에서 개행문자를 허용한다.

    // metacharacter(메타 문자)
    // \s : 공백
    // \w : 문자 하나
    // \W : 문자 이외
    // \d : 숫자
    // \D : 숫자 이외

    // quantifier(수량자)
    // n+ : 하나 이상의 n을 포함하는 모든 문자열

// match(string) : 찾을 문자열 또는 null을 반환.
let str4 = 'bad MORNING, GOOD AFTERNOON, good evening, and good night';
console.log(str4.match('good'));          // ['good', index: 29, input: 'bad MORNING, GOOD AFTERNOON, good evening, and good night', groups: undefined]
console.log(str4.match(/good/g));         // (2) ['good', 'good']
console.log(str4.match(/good/ig));        // (3) ['GOOD', 'good', 'good']
console.log(str4.match(/good\s\w/ig));    // (3) ['GOOD A', 'good e', 'good n']
console.log(str4.match(/good\s\w+/ig));   // (3) ['GOOD AFTERNOON', 'good evening', 'good night']


// replace(string, string) : 문자열 대체
console.log(str4.replace('good', 'better'));      // bad MORNING, GOOD AFTERNOON, better evening, and good night
console.log(str4.replace(/good/ig, 'better'));    // bad MORNING, better AFTERNOON, better evening, and better night
console.log(str4.replace(/\s/ig, '-'));           // bad-MORNING,-GOOD-AFTERNOON,-good-evening,-and-good-night
console.log(str4.replace(/\W/ig, '-'));           // bad-MORNING--GOOD-AFTERNOON--good-evening--and-good-night

let str5 ='money money100 money10000';
console.log(str5.replace(/\d/g, '')); // money money money
console.log(str5.replace(/\D/g, '')); // 10010000


console.clear();
let str6 = ['970101-1234567', '950505 1234567', '0003031234567', '880707/1234567'];
str6.forEach(num => console.log(num.replace(/\D/g, '')));


// + , concat() 문자열 합치기
console.log('hello' + ' world');
console.log('hello'.concat(' world', '!!', ' welcome'));

