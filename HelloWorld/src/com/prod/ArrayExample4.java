package com.prod;

public class ArrayExample4 {

	public static void main(String[] args) {

		int[] numbers = { 35, 22, 17, 40, 28, 50, 18 }; // 배열 초기화
		int sum = 0;
		int cnt = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				System.out.print(numbers[i] + ", ");
				sum += numbers[i];
				cnt++;
			}
		}
		
		int avg = sum / cnt;
		
		System.out.println("\n짝수 값의 합 : " + sum);
		System.out.println("짝수 값의 평균 : " + avg);
	}

}
