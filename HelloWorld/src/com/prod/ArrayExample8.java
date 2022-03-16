package com.prod;

import java.util.Scanner;

public class ArrayExample8 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] numbers = new int[2];
		
		System.out.print("첫 번째 정수를 입력하세요. > ");
		numbers[0] = scan.nextInt();
		System.out.print("두 번째 정수를 입력하세요. > ");
		numbers[1] = scan.nextInt();
		
		if (numbers[0] > numbers[1]) {
			int temp = numbers[0];
			numbers[0] = numbers[1];
			numbers[1] = temp;
		}
		
		System.out.println("첫 번째 값 : " + numbers[0]);
		System.out.println("두 번째 값 : " + numbers[1]);
	}

}
