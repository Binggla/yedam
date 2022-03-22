package com.edu.String;

public class StringTrimExample {

	public static void main(String[] args) {
		// trim() 메소드는 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴. 중간의 공백은 제거하지 않음.
		
		String tel1 = "   02 ";
		String tel2 = "123   ";
		String tel3 = "   12 34    ";
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);

	}

}
