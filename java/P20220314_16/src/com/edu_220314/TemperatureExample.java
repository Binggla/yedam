package com.edu_220314;

import java.util.Scanner;

public class TemperatureExample {

	public static void main(String[] args) {
		// C = 5/9(f-32) 화씨 온도를 섭씨온도로 변경규칙.
		
		Scanner scn = new Scanner(System.in);
		
		double fDeg, cDeg;
		int iCDeg;
		
		System.out.println("화씨 온도를 입력하세요.");
		fDeg = scn.nextDouble();
		cDeg = (double) 5 / 9 * (fDeg - 32);
		iCDeg = (int) cDeg;
		
		// 30.0보다 크면 "오늘은 더운 날씨네요." 그 외는 "살만하네요."
		if(cDeg > 30.0) {
			System.out.println(iCDeg + "도입니다. 오늘은 더운 날씨네요.");
		} else {
			System.out.println(iCDeg + "도입니다. 살만하네요.");
		}
		
		scn.close();

	}

}
