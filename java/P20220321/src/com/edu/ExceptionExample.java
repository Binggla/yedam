package com.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {

	public static void main(String[] args) {
		// Error
		// Exception
		// 컴파일 에러 / 런타임 에러

//		try {
//			double result = 13 / 0;
//			System.out.println("결과 : " + result);
//		} catch (ArithmeticException e) {
////			e.printStackTrace();
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
//		Scanner scan = new Scanner(System.in);
//
//		try {
//			System.out.print("숫자 입력 > ");
//			int menu = scan.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("숫자를 입력하라고");
//		}
//
//		System.out.println("end of prog");
		
		showInterval("HELLO WORLD\nHELL JAVA");
	}
	
	public static void showInterval(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
