package com.dev_220316;

import java.util.Scanner;

public class work1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int num1, num2, cha;
		
		System.out.println("첫 번째 정수를 입력하세요.");
		num1 = scan.nextInt();
		System.out.println("두 번째 정수를 입력하세요.");
		num2 = scan.nextInt();
		
		cha = (num1 > num2) ? num1 - num2 : num2 - num1;
		System.out.println("두 수의 차 : " + cha);
		
		scan.close();
	}

}
