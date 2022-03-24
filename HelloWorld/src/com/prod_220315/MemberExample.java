package com.prod_220315;

public class MemberExample {

	public static void main(String[] args) {
		
		Member mem = new Member();	// name, age 속성에 값이 아직 없는 상태.
		
		mem.age = 28;
		mem.name = "지수빈";
		
		System.out.println("mem의 name 속성 : " + mem.name);
		System.out.println("mem의 age 속성 : " + mem.age);
		
		Member mem2 = new Member();
		
		mem2.age = 25;
		mem2.name = "김민수";
		
		System.out.println("mem2의 name 속성 : " + mem2.name);
		System.out.println("mem2의 age 속성 : " + mem2.age);
		
		// -------------------------------------------------------------
		
		Student stu = new Student();
		stu.studentNo = "22-1234987";
		stu.studentName = "김영희";
//		stu.korScore = 90;
//		stu.engScore = 80;
		
		Student stu2 = new Student();
		stu2.studentNo = "22-1234654";
		stu2.studentName = "박철수";
//		stu2.korScore = 95;
//		stu2.engScore = 75;
	}

}
