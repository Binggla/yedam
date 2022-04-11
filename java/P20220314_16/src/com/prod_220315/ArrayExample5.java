package com.prod_220315;

public class ArrayExample5 {

	public static void main(String[] args) {

		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		int sum = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (i % 2 == 0) {
				System.out.print(numbers[i] + ", ");
				sum += numbers[i];
			}
		}

		System.out.println("\n홀수번째 값들의 합 : " + sum);

	}

}

