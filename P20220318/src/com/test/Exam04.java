package com.test;

import java.util.Scanner;

//문제4) 1 ~ 6까지 임의의 정수를 생성하는 Math.random()을 사용하여 작성하세요.
//생성된 값을 정수배열(크기 5)를 선언 후 값을 저장 후 가장 큰 값을 구하는 코드를 작성.
public class Exam04 {
	public static void main(String[] args) {

		int[] ranNumArr = new int[5];

		for (int i = 0; i < ranNumArr.length; i++) {
			ranNumArr[i] = (int) (Math.random() * 6) + 1;
			System.out.print(ranNumArr[i] + " ");
		}

		int temp = ranNumArr[0];

		for (int i = 0; i < ranNumArr.length; i++) {
			if (temp < ranNumArr[i]) {
				temp = ranNumArr[i];
			}
		}

		System.out.println("\n랜덤값 중 가장 큰 수 : " + temp);

//		int temp;
//		for (int i = 0; i < ranNumArr.length; i++) {
//			for (int j = i+1; j < ranNumArr.length; j++) {
//				if(ranNumArr[i] > ranNumArr[j]) {
//					temp = ranNumArr[j];
//					ranNumArr[j] = ranNumArr[i];
//					ranNumArr[i] = temp;
//				}
//			}
//		}

	}
}
