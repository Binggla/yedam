package com.dev;

public class ForExample {

	public static void main(String[] args) {
		
		int sum = 0;
		for (int i = 1; i <= 15; i++) {
			System.out.println(i);
			sum = sum + i;
		}
		
		System.out.println("합계 : " + sum);

	}

}
