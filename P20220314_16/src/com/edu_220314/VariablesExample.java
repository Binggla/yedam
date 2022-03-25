package com.edu_220314;

public class VariablesExample {

	public static void main(String[] args) {
		// 변수의 타입.
		
		int num1 = 100;				// 정수 4byte
		double num2 = 100.5;		// 실수 8byte
		double result = num1 * num2;			// 자동형변환(promotion) : 작은 범위 -> 큰 범위
		int result2 = num1 * (int) num2;		// 강제형변환(casting) : 큰 범위 -> 작은 범위
		
		System.out.println(result);
		System.out.println(result2);
		
		int n1 = 10;
		int n2 = 4;
		
		double n3 = n1 / n2;
		double n4 = (double) n1 / n2;
		
		System.out.println(n3);		// 2.0
		System.out.println(n4);		// 2.5
		
		
		

	}

}
