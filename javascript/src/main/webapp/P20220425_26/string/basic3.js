// string/basic.js
// 템플릿 리터럴(Template Literal) : 백틱(``)

// 1. 줄바꿈(개행: Multi-line strings) 
let str2 = `Welcome
to my home,
This my Sweet Home.
`;
str2 = 'Welcome\nto my home,\nThis my Sweet Home.\n';
console.log(str2);

// 2. 표현식 삽입(Expression interpolation)
// ${ } 사이에 변수나 연산 등을 삽입할 수 있게 되었다.
let str1 = 'hello';
console.log(`${str1}`);

let age = 22;
console.log(`${age>=20?'성인':'청소년'}`);