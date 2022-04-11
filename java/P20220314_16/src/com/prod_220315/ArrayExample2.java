package com.prod_220315;

public class ArrayExample2 {

	public static void main(String[] args) {

		int[] ages = new int[3];

		ages[0] = 20;
		ages[1] = 23;
//		ages[2] = 27;	// int 배열의 빈 값은 0으로 채워진다.

		for (int i = 0; i < ages.length; i++) {
			System.out.println(ages[i] + "살입니다.");
		}

		int sumAge = 0;

		for (int i = 0; i < ages.length; i++) {
			sumAge += ages[i];
		}

		double avgAge = (double) sumAge / 3;

		System.out.printf("평균 나이 : %.3f\n", avgAge);

		ages[0] = 30;
		ages[1] = 32;
		ages[2] = 35;

		for (int i = 0; i < ages.length; i++) {
			System.out.println(ages[i] + "살입니다.");
		}

		sumAge = 0;

		for (int i = 0; i < ages.length; i++) {
			sumAge += ages[i];
		}

		avgAge = (double) sumAge / 3;

		System.out.printf("평균 나이 : %.3f", avgAge);

	}

}
