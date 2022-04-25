// practice3.js

const person1 = {
  fullName: 'Jee',
  age: 20,
  height: 175.3
}

const person2 = {
  fullName: 'Su',
  age: 27,
  height: 169.0
}

const person3 = {
  fullName: 'Bin',
  age: 23,
  height: 187.3
}

const persons = [person1, person2, person3];

//map() : forEach()와 기능은 유사하지만, 결과값을 새로운 배열에 담아 반환한다.
// 배열의 길이만큼 가지고 와서 배열의 길이만큼 반환해줄게.
let newPersons = persons.map((val, idx) =>val.age);
console.log(newPersons); // (3) [20, 27, 23]

newPersons = persons.map(function (val, idx) {
  let newObj = {};                   // Object Type 선언
  newObj.idx = idx;                  // Object의 Field(=Attribute) 추가
  newObj.fullName = val.fullName;
  newObj.age = val.age;
  newObj.height = val.height;

  return newObj;                     // Object를 반환
});

console.log(newPersons);
// (3) [{…}, {…}, {…}]
// 0: {index: 0, fullName: 'Jee', age: 20, height: 175.3}
// 1: {index: 1, fullName: 'Su', age: 27, height: 169}
// 2: {index: 2, fullName: 'Bin', age: 23, height: 187.3}

function tableList(personAry) {
  document.write('<table border=1>');
  for (let person of personAry) {
    document.write('<tr>');
    for (let field in person) {
      document.write(`<td>${person[field]}</td>`);
    }
    document.write('</tr>')
  }
  document.write('</table>');
}

tableList(newPersons);


