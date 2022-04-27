// dom/practice3.js

document.addEventListener('DOMContentLoaded', function () {
  let showDiv = document.querySelector('#show');
  // === document.getElementById('show')
  showDiv.style.width = '300px';
  showDiv.style.height = '300px';
  showDiv.style.backgroundColor = 'yellow';

  // input에 change 이벤트 추가
  let inputTag = document.getElementById('userName');
  inputTag.addEventListener('change', function() {
    let span = document.createElement('span');
    span.style.display = 'inline-block';
    span.style.padding = '5px';
    span.style.marginRight = '2px';

    span.style.backgroundColor = 'red';
    span.style.color = 'white';
    span.innerHTML = document.querySelector('#userName').value;
    showDiv.appendChild(span);

    // value -> clear
    document.querySelector('#userName').value = '';
  });


  // button에 click 이벤트 추가
  let add = document.querySelector('#addBtn');
  add.addEventListener('click', function() {
    let span = document.createElement('span');
    span.style.display = 'inline-block';
    span.style.padding = '5px';
    span.style.marginRight = '2px';

    span.style.backgroundColor = 'red';
    span.style.color = 'white';
    span.innerHTML = document.querySelector('#userName').value;
    showDiv.appendChild(span);

    // value -> clear
    document.querySelector('#userName').value = '';
  });

});