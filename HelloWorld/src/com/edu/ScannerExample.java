package com.edu;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자를 입력하세요. > ");
		int val1 = scn.nextInt();
		System.out.println("두 번째 숫자를 입력하세요. > ");
		int val2 = scn.nextInt();
		
		int sum = val1 + val2;
		System.out.println("두 수의 합은 " + sum + "입니다.");
		
//		if(val % 2 == 0) {
//			System.out.println("짝수입니다.");
//		}
//		if(val % 2 == 1) {
//			System.out.println("홀수입니다.");
//		}
		
		scn.close();
		
		
	}

}
