package com.dev_220316;

import java.util.Scanner;

public class ForExample3 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		int sum = 0;
		
		System.out.println("첫 번째 정수를 입력하세요.");
		num1 = scan.nextInt();
		System.out.println("첫 번째 정수보다 큰 두 번째 정수를 입력하세요.");
		num2 = scan.nextInt();
		
		for (int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.println(num1 + "에서 " + num2 + " 사이 모든 정수의 합 : " + sum);
		
		scan.close();
		
	}
}
