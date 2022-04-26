// dom/practice1.js

document.addEventListener('DOMContentLoaded', function() {
  let ulTag = document.createElement('ul');

  // let li = document.createElement('li');
  // li.innerHTML = '아메리카노';
  // ul.appendChild(li);
  
  // li = document.createElement('li');
  // li.innerHTML = '카페라떼';
  // ul.appendChild(li);

  // li = document.createElement('li');
  // li.innerHTML = '바닐라라떼';
  // ul.appendChild(li);

  let menus = ['아메리카노', '카페라떼', '바닐라라떼'];

  // for (let i = 0; i < menus.length; i++) {
  //   let liTag = document.createElement('li');
  //   liTag.innerHTML = menus[i];
  //   ulTag.appendChild(liTag);
  // }

  menus.forEach(function(val) {
    let liTag = document.createElement('li');
    liTag.innerHTML = val;
    ulTag.appendChild(liTag);
  });


  document.getElementById('show').appendChild(ulTag);
});