package com.prod_220315;

public class ArrayExample6 {

	public static void main(String[] args) {
		
		int[] numbers = { 35, 22, 17, 40, 28, 33, 36 };
		int sum = 0;
		int cnt = 0;
		
		for (int i=0; i<numbers.length; i++) {
			if (30 <= numbers[i] && numbers[i] < 40) {
				System.out.print(numbers[i] + ", ");
				sum += numbers[i];
				cnt++;
			}
		}
		
		double avg = (double) sum / cnt;
		
		System.out.println("\n30보다 크고 40보다 작은 값들의 합 : " + sum);
		System.out.printf("30보다 크고 40보다 작은 값들의 평균 : %.2f", avg);		

	}

}
