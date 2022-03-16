package com.prod;

public class ReferenceExample {

	public static void main(String[] args) {
		// 참조타입 vs 기본(데이터)타입
		
		int num1 = 10;	// 리터럴
		int num2 = 10;
		// int, double, (byte, short, long, float, char)

		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num1 == num2);

		String str1 = "Hello";	// 리터럴
		String str2 = "Hello";
		String str3 = new String("Hello");

		System.out.println(str1 == str2);		// true	 // 문자열 리터럴로 생성했을 때는 동일한 주소값을 가지기 때문에 true.
		System.out.println(str1 == str3); 		// false // ==는 str1과 str3가 참조하고 있는 주소값이 다르기 때문에 false.
		System.out.println(str1.equals(str3));	// true  // 문자열 비교 시에는 ==가 아닌 equals() 메소드를 사용한다.

	}

}
