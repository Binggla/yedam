package com.dev_220316;

import java.util.Scanner;

public class ForExample5 {

	public static void main(String[] args) {

		// 약수 구하기

//		int num = 48;
//
//		for (int i = 1; i <= num; i++) {
//			if (num % i == 0) {
//				System.out.print(i + " ");
//			}
//		}

		// 최대공약수 구하기

		Scanner scan = new Scanner(System.in);
		int num, num2, comDiv = 0;

		System.out.println("첫 번째 정수를 입력하세요.");
		num = scan.nextInt();
		System.out.println("첫 번째 정수보다 큰 두 번째 정수를 입력하세요.");
		num2 = scan.nextInt();

		for (int i = 1; i <= num2; i++) {
			if (num % i == 0 && num2 % i == 0) {
				comDiv = i;
			}
			
		}

		System.out.println(num + "과 " + num2 + "의 최대공약수 : " + comDiv);
		
		scan.close();

	}

}
