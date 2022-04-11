package com.test;

import java.util.Scanner;

//문제3) 정수형배열 선언하고 사용자로 세개의 정수값을 입력받아서 배열에 저장. 제일 큰값을 구하는 코드를 작성.
public class Exam03 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int[] iNum = new int[3];

		System.out.println("첫 번째 정수 입력 > ");
		iNum[0] = scan.nextInt();
		System.out.println("두 번째 정수 입력 > ");
		iNum[1] = scan.nextInt();
		System.out.println("세 번째 정수 입력 > ");
		iNum[2] = scan.nextInt();

		int temp;
		for (int i = 0; i < iNum.length; i++) {
			for (int j = i+1; j < iNum.length; j++) {
				if(iNum[i] > iNum[j]) {
					temp = iNum[j];
					iNum[j] = iNum[i];
					iNum[i] = temp;
				}
			}
		}
		
		System.out.println("입력값 중 가장 큰 수 : " + iNum[2]);

	}
}
