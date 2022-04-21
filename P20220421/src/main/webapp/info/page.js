// page.js

console.log(member1);

let field = 'fullName';
console.log(member1.fullName);
console.log(member2['fullName']);
console.log(member3[field]); // 변수를 통해서도 불러올 수 있다.

// 배열 요소를 반복적으로 for of
for(let m of members) {
  console.log(`${m.fullName}의 나이는 ${m.age}이고, 점수는 ${m.score}점입니다.`);
}

// 오브젝트의 속성(필드)를 반복적으로 출력 for in
// for ( let field in member1) {
//   console.log(`${field} => ${member1[field]}`);
// }

// 각 배열요소의 각 필드를 출력.
document.write('<table border=1>');
let fields = ['fullName', 'score', 'age'];
for(let member of members) {
  document.write('<tr>');
  for ( let prop of fields) {
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write('<td><button>클릭</button></td>')
  document.write('</tr>');
  console.log('------------------');
}
document.write('</table>');

