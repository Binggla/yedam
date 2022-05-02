// ajax/ajax.js

// 비동기

// setTimeout(실행할 콜백함수, 시간(텀))
let val = 10;
setTimeout(function(){
  val += 5;
  console.log('hello -> ' + val);
  
  setTimeout(function(){
    val += 3;
    console.log('hello2 -> ' + val);

    setTimeout(function(){
      val += 3;
      console.log('hello3 -> ' + val);
    }, 1000)

  }, 1000)

}, 2000)


let success = true;

// new Promise() 메서드를 호출할 때 콜백 함수를 선언할 수 있고, 콜백 함수의 인자는 resolve, reject.
let promise = new Promise(function(resolve, reject) {
  if (success) {
    resolve('success'); // 정상 처리 시 실행 // resolve() -> then()
  } else {
    reject('error');    // 에러 발생 시 실행 // reject() -> catch()
  }
});

promise.then(function(result) {
          console.log(result);
       })
       .catch(function(err) {
          console.log(err);
       });