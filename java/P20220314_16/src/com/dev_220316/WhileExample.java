package com.dev_220316;

import java.util.Scanner;

public class WhileExample {

	public static void main(String[] args) {

//		// for
//		for (int i = 1; i <= 5; i++) {
//			System.out.println(i);
//		}
//
//		System.out.println("---------");
//
//		// while
//		int i = 1;
//		while (i <= 5) {
//			System.out.println(i);
//			i++;
//		}
//
//		System.out.println("---------");
//
//		// while
//		int num = 0;
//		while (true) {
//			System.out.println(num);
//			num++;
//			if (num >= 5) {
//				break; // 반복문을 빠져나옴.
//			}
//		}
//
//		System.out.println("---------");
//
//		// while
//		while (true) {
//			int ranVal = (int) (Math.random() * 10) + 1;
//			if (ranVal == 8) {
//				break;
//			}
//			System.out.println("임의로 생성된 값 : " + ranVal);
//		}
//
//		System.out.println("---------");

		Scanner scan = new Scanner(System.in);
		int ranVal, userVal;

		ranVal = (int) (Math.random() * 3) + 1;

		while (true) {

			System.out.println("1~3 사이의 정수를 입력하세요.");
			userVal = scan.nextInt();

			if (userVal == ranVal) {
				System.out.println("정답입니다.");
				break;
			}
		}

		System.out.println();
		System.out.println("end of program");

		scan.close();
	}

}
