window.addEventListener('load', function() {
  let txt = $('h1').text();      // 첫 번째 값만 저장
  $('h1').text("Hello jQuery!"); // 묵시적 반복. 전체 요소.

})