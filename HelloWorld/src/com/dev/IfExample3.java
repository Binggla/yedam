package com.dev;

import java.util.Scanner;

public class IfExample3 {

	public static void main(String[] args) {
		
		int ranVal = (int) (Math.random() * 3) + 1; // +1을 해주어야 1부터 시작.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("1에서 3 사이의 정수를 입력하세요.");
		int inputVal = scan.nextInt();
		
		if (inputVal == ranVal) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}

		
	}

}
