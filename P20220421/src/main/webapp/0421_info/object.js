// object.js

// {key: value} -> Object Type
let member1 = {
  fullName: 'Kim',
  age: 20,
  score: 80
};

let member2 = {
  fullName: 'Lee',
  age: 30,
  score: 100
};

let member3 = {
  fullName: 'Park',
  age: 26,
  score: 95
};

// 객체명.객체변수명
member1.fullName = "Jee";

console.log(member1.fullName);
console.log(member2.age);
console.log(member2.age+member3.age); // 연산 가능

const members = [member1, member2, member3];
// 홍의 나이는 20이고, 점수는 80입니다.
document.write('<ul>')
for (let m of members) {
  // document.write('<ul><li>' + m.fullName + '의 나이는 ' + m.age +'이고, 점수는 ' + m.score + '점입니다. </li></ul>')
  document.write(`<li> ${m.fullName}의 나이는 ${m.age}이고, 점수는 ${m.score}점입니다. </li>`)
}
document.write('</ul>');
let welcome = `안녕하세요.
반갑습니다.`;
console.log(welcome);

// document.write('<ul><li>' + '</li></ul>')