package com.edu.String;

public class StringEqualsExample {

	public static void main(String[] args) {
		// eqauls() 메소드는 문자열 비교 시에 사용된다.
		
		String strVar1 = new String("지수빈")	;
		String strVar2 = "지수빈";
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");
		}
	
		if(strVar1.equals(strVar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");
		}
	}

}
