package com.edu.thread;

// 클래스 병렬처리 예시(쓰레드 클래스 상속받아서 만드는 방법)

import java.awt.Toolkit;

class BeepThread extends Thread {

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

public class BeepPrintExample2 {
	public static void main(String[] args) { // main메소드를 멀티쓰레드로 실행
		
		// 쓰레드 생성
		// Thread class를 상속받아 구현된 BeepThread 클래스를 선언.
		Thread thread = new BeepThread();
		thread.start();

		// 2. 비프 문장 출력
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
