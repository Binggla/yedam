// object/calendar_prac.js

let year = 2022;
let month = 0;

function showCalendar(month=5) {

let frontSpace = getFirstDate(month);
let lastDate = getLastDate(month);
const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']


document.write('<div style = "text-align: center;">')
document.write(`<h2 style = "text-align: center;">${year}/${month}</h2>`)
document.write('<table style = "text-align: center; display: inline-block; border-collapse:collapse;"><tr>')
// 요일 출력
for (let day of days) {
  document.write(`<td style="background:gray; color:white; width: 50px; height: 30px; border:1px solid black">${day}</td>`)
}
document.write('</tr>')

// 앞 빈 공간 출력
for (let i = 0; i < frontSpace; i++) {
  document.write('<td style = "border:1px solid black;"> </td>')
}

// 날짜 출력
for (let i = 1; i <= lastDate; i++) {
  document.write(`<td style = "background-color: ${textColor(frontSpace+i)}; width: 50px; height: 30px; border:1px solid black">${i}</td>`)
  if ((frontSpace+i) % 7 === 0) {
    document.write('</tr><tr>');
  }
}

// 뒷 빈 공간 출력

for (let i = 0; i < (7-(frontSpace+lastDate)%7); i++) {
  if ((frontSpace + lastDate) % 7 === 0) {
    break;
  }
  document.write('<td style = "border:1px solid black;"> </td>')
}
 
document.write('</table>')
document.write('</div>')

}

// 주말 색 변경
function textColor(month) {
  if (month % 7 === 0) { 
    return 'blue; font-weight: bold; color: white;';
  } else if (month % 7 === 1) {
    return 'red; font-weight: bold; color: white;';
  } else {
    return '';
  }

}

// 마지막 요일 계산
function getLastDate(month) {
  switch (month) {
    case 1: return 31;
    case 2: return 28;
    case 3: return 31;
    case 4: return 30;
    case 5: return 31;
    case 6: return 30;
    case 7: return 31;
    case 8: return 31;
    case 9: return 30;
    case 10: return 31;
    case 11: return 30;
    case 12: return 31;
  }
}

// 1일 요일 계산
function getFirstDate(month) {
  switch (month) {
    case 1: return 6;
    case 2: return 2;
    case 3: return 2;
    case 4: return 5;
    case 5: return 0;
    case 6: return 3;
    case 7: return 5;
    case 8: return 1;
    case 9: return 4;
    case 10: return 6;
    case 11: return 2;
    case 12: return 4;

  }
}
// console.log(getFirstDate(month));


showCalendar(10);