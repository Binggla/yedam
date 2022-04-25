// dom/practice.js

document.addEventListener('DOMContentLoaded', function() {
  let btn = document.querySelector('button');
  btn.addEventListener('click', function() {
    // 입력값1, 입력값2
    let name = document.getElementById('userName').value;
    let age = document.getElementById('userAge').value;
  
    let span1 = document.createElement('span');
    span1.innerHTML = name; // <span>${name}</span>
    let span2 = document.createElement('span');
    span2.innerHTML = age; // <span>${age}</span>
    let div1 = document.createElement('div');
    div1.appendChild(span1); // <div><span>${name}</span></div>
    div1.appendChild(span2); // <div><span>${name}</span><span>${age}</span></div>
  
    document.getElementById('show').appendChild(div1);
  })
});