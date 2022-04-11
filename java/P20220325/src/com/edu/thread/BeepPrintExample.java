package com.edu.thread;

import java.awt.Toolkit;

class BeepTask implements Runnable {

	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for (int i = 0; i < 5; i++) {
			toolkit.beep();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

// 이전까지 main thread 즉, 싱글 스레드를 사용해왔으나 멀티 스레드로 병렬 처리 가능.
public class BeepPrintExample {
	public static void main(String[] args) {

		// 쓰레드 생성하기
		// 1. Thread class thread의 생성자의 매개값으로 'Runnable 인터페이스를 구현한 객체 BeepTask'를 선언.
		Thread thread = new Thread(new BeepTask());
		
		// 2. Thread class thread의 생성자의 매개값으로 'Runnable interface의 익명 클래스'를 구현하여 선언.
		//	  1번의 방법과 동일한 기능을 가지지만, 클래스를 따로 선언해 줄 필요가 없다.
		Thread thread2 = new Thread (() -> {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			for (int i = 0; i < 5; i++) {
				toolkit.beep();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		thread2.start(); // 쓰레드 시작

		for (int i = 0; i < 5; i++) {
			System.out.println("beep");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("end of prog");

	}
}
