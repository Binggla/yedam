package com.edu.String;

public class StringReplaceExample {

	public static void main(String[] args) {
		// replace() 메소드는 첫 번째 매개값인 문자열을 찾아 두 번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴한다.
		// String 객체의 문자열은 변경이 불간으한 특성을 갖기 때문에 replace() 메소드가 리턴하는 문자열은 수정본이 아니라 새로운 문자열.
		
		String oldStr = "자바는 객체 지향 언어입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);

	}

}
