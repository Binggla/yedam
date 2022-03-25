package com.prod_220315;

public class Student {
	
	// variable
	String studentNo;
	String studentName;
	String editScore;
	String illustScore;
	
	
	// method : 기능, 함수
	void task(String subject) {		// 반환타입 메소드명(매개 변수(입력값))
		System.out.println(studentName + "은(는) " + subject + "을(를) 합니다.");
	}
	void eat(String food) {
		System.out.println(studentName + "은(는) " + food + "을(를) 먹습니다.");
	}
	
	String getEditScore() {
		return editScore;			// return : 반환값
	}
	
	String getIllustScore() {
		return illustScore;
	}
	
}
