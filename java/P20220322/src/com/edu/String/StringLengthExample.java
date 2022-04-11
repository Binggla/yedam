package com.edu.String;

public class StringLengthExample {

	public static void main(String[] args) {
		// length() 메소드는 문자열의 길이(문자의 수)를 리턴한다. (공백 포함)
		
		String ssn = "1242354365631";
		int length = ssn.length();
		if (length == 13) {
			System.out.println("주민번호 자리수가 맞습니다");
		} else {
			System.out.println("주민번호 자리수가 틀립니다");			
		}

	}

}
