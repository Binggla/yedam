package com.prod;

class Calculator {
	// 필드
	double PI = 3.14;

	// 메소드(매개변수, parameter) 정의
	int add(int n1, int n2) {
		return n1 + n2;
	}

	int minus(int n1, int n2) {
		int result = (n1 > n2) ? n1 - n2 : n2 - n1;
		return result;
	}
	
	double getRectArea(double x, double y) {
		return x * y;
	}
	
	double getCirArea(double radius) {
		return PI * radius * radius;
	}

}

public class CalculatorExample {

	public static void main(String[] args) {

		Calculator cal = new Calculator();
		System.out.println(cal.PI);

		int number1 = 10;
		int number2 = 20;

		// 메소드(매개값, argument) 호출
		int resultAdd = cal.add(number1, number2);
		System.out.println(number1 + " + " + number2 + " = " + resultAdd);

		int resultMinus = cal.minus(number1, number2);
		if (number1 > number2) {
			System.out.println(number1 + " - " + number2 + " = " + resultMinus);
		} else {
			System.out.println(number2 + " - " + number1 + " = " + resultMinus);
		}
		
		double resultRectArea = cal.getRectArea(number1, number2);	// int type -> double type 자동형변환
		System.out.println("사각형의 넓이 : " + resultRectArea);
		
		double r = 4.5;
	
		double resultCirArea = cal.getCirArea(r);
		System.out.println("반지름 " + r + "의 넓이 : " + resultCirArea);

	}

}
