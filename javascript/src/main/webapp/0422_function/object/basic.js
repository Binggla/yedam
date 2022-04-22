// object/basic.js

// 객체 생성
const member = {
  memberId: 'user1',
  memberName: 'Jee',
  getMemberName: function() {
    return `회원 이름 : ${this.memberName}`;
  },
  setMemberName: function (name) {
    this.memberName = name;
  }
}

// 객체 사용
console.log(member.memberId);
console.log(member.getMemberName);
// ƒ () {
//   return `회원 이름 : %${this.memberName}`;
// }
console.log(member.getMemberName());  // 회원 이름 : Jee

member.setMemberName('Subin');
console.log(member.getMemberName());  // 회원 이름 : Subin


// 멤버 속성 추가
member.memberAge = 20;
member['memberPoint'] = 2000;

// 멤버 속성 삭제
delete member.memberAge;

console.log(member);
// {memberId: 'user1', memberName: 'Subin', memberPoint: 1000, getMemberName: ƒ, setMemberName: ƒ}

// 멤버 함수 추가
member.grade = function () {
  if (this.memberPoint > 1000) {
    return 'platinum'
  } else if (this.memberPoint > 500) {
    return 'gold'
  }
}

console.log(member.grade());

// 클래스(class)
class Student {
  constructor(sno, sname) {
    this.sno = sno;
    this.sname = sname;
  }
  getSno() {
    return this.sno;
  }
  setSno(sno) {
    this.sno = sno;
  }

  // 생성자 없이 get, set을 활용하여 멤버 추가 가능
  // 하지만 메소드는 아니기 때문에 객체 호출 시 ()는 붙이지 않는다.
  set mathScore(score) {
    this._mathScore = score;
  }
  get mathScore() {
    return this._mathScore;
  }
}
const s1 = new Student('1111', 'Park');
const s2 = new Student('2222', 'Kim');
console.log(`학생번호 : ${s1.getSno()}`);

s1.engScore = 80;
console.log(`영어 점수 : ${s1.engScore}`);

// mathScore 호출
//mathScore라는 멤버 속성을 생성하는 것이 아니라 mathScore라는 getter를 호출하는 것.
s1.mathScore = 90;
// mathScore 호출
// mathScore라는 멤버 속성을 읽어오는 것이 아니라 mathScore라는 setter를 호출하는 것.,
console.log(`영어 점수 : ${s1.mathScore}`);


// 생성자 함수
function Person(sno, sname) {
  this.sno = sno;
  this.sname = sname;
  this.getInfo = function() {
    return `주민번호 : ${this.sno} 이름 : ${this.sname}`;
  }
}

const p1 = new Person('951111-1111111', 'Hong');
const p2 = new Person('971111-1111111', 'Hwang');
const p3 = new Person('991111-1111111', 'Park');
console.log(p1.getInfo());