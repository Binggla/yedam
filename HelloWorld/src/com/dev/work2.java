package com.dev;

import java.util.Scanner;

public class work2 {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		int num1, num2, num3;

		System.out.println("첫 번째 정수를 입력하세요.");
		num1 = scan.nextInt();
		System.out.println("두 번째 정수를 입력하세요.");
		num2 = scan.nextInt();
		System.out.println("세 번째 정수를 입력하세요.");
		num3 = scan.nextInt();

		int[] numList = { num1, num2, num3 };

		for (int i = 1; i < numList.length; i++) {
			for (int j = 0; j < i; j++) {
				if (numList[i] < numList[j]) {
					int temp = numList[j];
					numList[j] = numList[i];
					numList[i] = temp;
				}
			}
		}

		for (int i : numList) {
			System.out.println(i);
		}

		scan.close();
	}

}
