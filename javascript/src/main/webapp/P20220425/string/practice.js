// string/practice.js

let str1 = 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Voluptatibus aut illum, quasi hic iusto saepe natus beatae provident delectus vel neque minus asperiores velit? Nemo alias facere hic a id!';
// 단어의 길이가 10개 이상인 값을 골라내서

let words = str1.split(' ');

let result = words.filter(function(val) {
   return val.length >= 10
});

console.log(result.join(', '));


result = str1.split(' ').filter(val => val.length >= 10).join(', ');

console.log(result);