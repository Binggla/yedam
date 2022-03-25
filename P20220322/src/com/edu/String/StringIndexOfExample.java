package com.edu.String;

public class StringIndexOfExample {

	public static void main(String[] args) {
		// indexOf() 메소드는 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴한다.
		// indexOf("a")일 때 a가 문자열에 속해있지 않으면 -1을 반환한다.
		
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);
		
		if(subject.indexOf("자바") != -1) {
			System.out.println("자바와 관련된 책이군요");
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}

	}

}
