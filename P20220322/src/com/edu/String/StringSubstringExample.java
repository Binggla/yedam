package com.edu.String;

public class StringSubstringExample {

	public static void main(String[] args) {
		// substring() 메소드는 주어진 인덱스에서 문자열을 추출한다.
		// 1. substring(int beginIndex, int endIndex)
		// 2. substring(int beginIndex) : 주어진 인덱스부터 끝까지
		
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0, 6);
		System.out.println(firstNum);
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum);

	}

}
