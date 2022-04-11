package com.test;

import java.util.Scanner;

//문제2) 정수형 변수 n1, n2를 선언하고 Scanner 클래스를 통하여 두정수를 입력받은 후 큰수에서 작은 수를 나눈 결과값을 소수점 첫번째까지 구하는 기능 작성. 
public class Exam02 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num1, num2; 
		double result;

		System.out.print("첫 번째 정수를 입력하세요. > ");
		num1 = scan.nextInt();

		System.out.print("두 번째 정수를 입력하세요. > ");
		num2 = scan.nextInt();

		result = (num1 > num2) ? (double) num1 / num2 : (double) num2 / num1;

		System.out.printf("두 수의 몫 : %.1f", result);
	}
}
