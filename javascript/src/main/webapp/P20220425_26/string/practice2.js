// string/pactice2.js

let sso = ['970101-1234567', '950505 2234567', '0003033234567', '880707/4234567'];



function checkGender(ssn) {
 let num = ssn.replace(/\D/g, '').charAt(6);
  if (num === '1' || num === '3') {
    return '남자';
  } else if (num === '2' || num === '4') {
    return '여자';
  };

}

sso.forEach(function(num) {
  let result = checkGender(num);
  console.log(`${num} : ${result}`);
});