package com.edu.nested;

// Outer class
public class Outer {
	
	private String field1;
	private String field2;

	// instance class
	class InstanceInner {
		String field3;
		void method2() {
			System.out.println("InstanceInner.method2()");
		}
	}
	
	public void method1() {
		System.out.println("Outer.mothod1()");
		
		// local class
		class LocalInner {
			void method4() {
				System.out.println("LocalInner.method4()");
			}
		}
		LocalInner local = new LocalInner();
		local.method4();
	}
	
	// -----------------------------------------------------------------------
	
	// 함수적 인터페이스 : 구현해야할 메소드가 하나인 것.
	interface Runnable {
		void run();
	}
	
	// 클래스로 인터페이스를 구현
	class Bus implements Runnable {
		@Override
		public void run() {
			System.out.println("버스가 달립니다.");
		}
	}
	
	public void method4() {
		
		// 익명 구현 객체로 인터페이스를 구현. 
		// 추상메소드를 재정의하여 한 번만 사용하는 객체. 메소드 안에서만 선언 가능.
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("임의의 객체를 실행합니다.");
			}
		};

		runnable.run();

		// 람다식으로 인터페이스 구현.
		Runnable runnable2 = () -> System.out.println("임의의 객체2를 실행합니다.");
		runnable2.run();
		
	}
	

}
