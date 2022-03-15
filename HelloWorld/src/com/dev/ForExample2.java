package com.dev;

public class ForExample2 {

	public static void main(String[] args) {

		for (int i = 1; i <= 3; i++) {
			System.out.println(i);
		}
		System.out.println("---------");

		for (int i = 4; i <= 6; i++) {
			System.out.println(i);
		}
		System.out.println("---------");

		for (int i = 5; i > 0; i--) {
			System.out.println(i);
		}
		System.out.println("---------");
		
		for (int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("---------");

		for (int i = 2; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("---------");
		
		
		int sum = 0;
		int startCnt = 11;
		int lastCnt = 20;
		for (int i = startCnt ; i <= lastCnt; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
				sum += i;
			}
		}
		
		System.out.println("짝수의 합 : " + sum);
		System.out.println("---------");

	}

}
