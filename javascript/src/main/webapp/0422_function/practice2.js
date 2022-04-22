// practice2.js

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

let sum=0, avgAge = 0, avgHeight=0;
for (let person of persons) {
  sum += person.age;
}

avgAge = sum / persons.length;
console.log(`평균 나이 : ${avgAge}`);


sum = 0;
persons.forEach(function (val) {
  sum += val.age;
})
console.log(`평균 나이 : ${sum/persons.length}`);

sum = 0;
let avgHeightFnc = (val) => {
  sum += val.height;
}

persons.forEach(avgHeightFnc);
avgHeight = sum / persons.length;
console.log(`평균 키 : ${avgHeight}`);

let tag = "";
let allPerson = function (val, idx) {
  if (idx === 0) {
    tag += '<ul>';
  }
  tag += `<li> ${val.fullName}, ${val.age}, ${val.height} </li>`;
  if (idx === persons.length-1) {
    tag += '</ul>';
  }
}
persons.forEach(allPerson);

let over170 = function (val, idx) {
  if (idx === 0) {
    tag += '<ul>';
  }
  if (val.height >=170) {
    tag += `<li> ${val.fullName}, ${val.age}, ${val.height} </li>`;
  }
  if (idx === persons.length-1) {
    tag += '</ul>';
  }
}
persons.forEach(over170);

document.write(tag);