package com.edu.lambda;

// 함수형 인터페이스를 생성할 때 람다식으로 간단하게 표현할 수 있다. (함수형 인터페이스 -> P20220322\com.edu.nested\Outer)

// 1. 매개변수가 없는 인터페이스
interface Runnable {
	public void run();
}

class RunImpl implements Runnable {
	@Override
	public void run() {
		System.out.println("run...");
	}
}

// 2. 매개변수가 있는 인터페이스
interface Runnable2 {
	public void run(String animal);
}

// 3. 매개변수와 반환값이 있는 인터페이스
interface Runnable3 {
	public int run(String str);
}

// 4. 반환값이 있는 인터페이스
interface Runnable4 {
	public int run(); 
}

public class LambdaExample {

	public static void main(String[] args) {
		
		// 1. 매개 변수가 없는 익명 클래스 생성
		
		Runnable runnable = new RunImpl();
		runnable.run();
		
		runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("호랑이가 달립니다.");
			}
		};
		runnable.run();
		
		
		// 람다표현식 (String s) -> { 구현코드 };
		runnable = () -> System.out.println("토끼가 달립니다.");
		runnable.run();
		
		System.out.println();
		
		
		// 2. 매개변수가 있는 익명 클래스 --------------------------------------------------------------------------
		
		Runnable2 runnable2 = new Runnable2() {

			@Override
			public void run(String animal) {
				System.out.println(animal + "이/가 달립니다.");
			}
		};
		runnable2.run("호랑이");

		Runnable2 runnable3 = (String animal) -> System.out.println(animal + "이 달립니다.");
		runnable3.run("말");
	
		System.out.println();
		
		// 3. 매개변수와 반환값이 있는 익명 클래스 --------------------------------------------------------------------------

		
		Runnable3 runnable4 = (String str) -> str.length();
		// Runnable3 runnable4 = (String str) -> { return str.length() };
		System.out.println(runnable4.run("Hello, World!"));

		System.out.println();
		
		// 4. 반환값이 있는 익명 클래스 --------------------------------------------------------------------------
		
		Runnable4 runnable5 = () -> (int) (Math.random() * 10);
		System.out.println(runnable5.run());
		
		
	}

}
