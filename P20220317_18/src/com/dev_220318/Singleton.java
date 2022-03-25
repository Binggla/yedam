package com.dev_220318;

public class Singleton {

	private static Singleton instance = new Singleton();	// static 변수이지만, private 접근 제어자로 다른 클래스에서는 접근 불가. 메소드로 접근하도록 한다.
	
	// 생성자
	private Singleton() {
		
	}
	
	// 메소드
	public static Singleton getInstance()	{
		return instance;
	}

}
