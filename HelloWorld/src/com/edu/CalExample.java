package com.edu;

import java.util.Scanner;

public class CalExample {

	public static void main(String[] args) {
		// 초(ex. 100초) 입력 -> 시/분/초로 변경
		
		Scanner scn = new Scanner(System.in);
		int hour, minute, second, inputVal;
		
		System.out.println("초 단위 입력(ex: 150)");
		inputVal = scn.nextInt();
		
		hour = inputVal / 3600;
		minute = inputVal % 3600 / 60;
		second = inputVal % 60;
		
		System.out.println("초 -> 시:분:초 변경 결과");
		System.out.println(hour + ":" + minute + ":" + second);
		scn.close();

	}

}
