package com.dev;

import java.util.Scanner;

public class WhileExample3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sum = 0;

		while (true) {
			System.out.println("정수를 입력하세요. 종료하시려면 -1을 입력하세요.");
			int inputVal = scan.nextInt();
			if (inputVal == -1) {
				break;
			}
			sum += inputVal;
		}

		System.out.println("합계는 " + sum + "입니다.");
		scan.close();
	}

}
