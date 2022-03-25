package com.edu_220314;

public class OperatorExample {

	public static void main(String[] args) {
		
		int num1, num2, result;
		
		num1 = 10;
		num2 = 100;

		num1 += 20;	//30
		num2 -= 50;	//50
		num1++;		//31
		num2--;		//49
		num2--;		//48
		
		result = num1 + num2;
//		System.out.println("result=> " + result);
		
		
		// Boolean Type
		int myAge = 19;
		myAge = 29;
		boolean isAdult = myAge >= 20;
		System.out.println(isAdult);
		
		// 논리 연산자
		if (isAdult) {
			System.out.println("성인입니다.");
		} else {
			System.out.println("미성년입니다.");
		}

	}

}
