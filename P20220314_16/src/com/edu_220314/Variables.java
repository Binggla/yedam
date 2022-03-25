package com.edu_220314;

public class Variables {

	public static void main(String[] args) {
		// 변수 : 메모리 공간에 이름을 지정하고 값을 할당.
		int age = 20;
		int num1 = 30;
		int num2 = 50;
		int result = num1 + num2;
		
		System.out.println("age 변수 : " + age);
		System.out.println(num1 + " + " + num2 + " = " + result);
		System.out.println("20 + 10 = 30");
		
		String name = "홍길동"; // 문자열
		System.out.println(name + "의 나이는 " + age + "입니다.");
		name = "최민규";
		System.out.println(name + "의 나이는 " + age + "입니다.");
		
		final String myName = "지수빈"; // 상수(Constance) : 바뀔 수 없는 수
//		myName = "이수빈"; // Error. 상수는 값을 바꿀 수 없음.
		
		
		// 전화번호, 이메일 값을 담을 수 있는 변수.
		String phoneNum = "010-1234-5678";
		String email = "abc@email.com";
		System.out.println(myName + "의 전화번호는 " + phoneNum + "이고 이메일은 " + email);

	}

}
