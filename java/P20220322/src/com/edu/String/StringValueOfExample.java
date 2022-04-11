package com.edu.String;

public class StringValueOfExample {

	public static void main(String[] args) {
		// valueOf() 메소드는 기본 타입의 값을 문자열로 변환하는 기능.
		// String 클래스는 매개 변수의 타입별로 valueOf() 메소드가 다음과 같이 오버로딩되어 있다.
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		
	}

}
