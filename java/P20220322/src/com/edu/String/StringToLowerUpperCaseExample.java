package com.edu.String;

public class StringToLowerUpperCaseExample {

	public static void main(String[] args) {
		// toLowerCase() 메소드는 문자열을 모두 소문자로 바꾼 새로운 문자열을 생성한 후 리턴
		// toUpperCase() 메소드는 문자열을 모두 대문자로 바꾼 새로운 문자열을 생성한 후 리턴
		
		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		
		System.out.println(str1.equals(str2)); // false // 대소문자 구분됨
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2)); // true // 모두 소문자로 변경한 후에는 비교 가능
		
		// equalsIgnoreCase() : 대소문자로 변경하지 않아도 두 문자열을 비교할 수 있다.
		System.out.println(str1.equalsIgnoreCase(str2));
;
	}

}
