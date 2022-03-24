package com.edu.api;

import java.util.Calendar;

public class CalenderExample {

	public static void main(String[] args) {

//		Calendar today = Calendar.getInstance();

		// 오늘 날짜 설정
//		today.set(2022, 2, 1);
//		System.out.println(today.get(Calendar.YEAR) + "년");
//		System.out.println((today.get(Calendar.MONTH) + 1) + "월"); // 1월부터 0으로 시작
//		System.out.println((today.get(Calendar.DATE)) + "일");
//		System.out.println(today.get(Calendar.DAY_OF_WEEK) + "요일"); // 일요일부터 1로 시작
//		System.out.println("마지막 날의 정보 : " + today.getActualMaximum(Calendar.DATE));
//		System.out.println();
		
		createCalendar(2023, 4);

		System.out.println("\r\n\r\nEnd of Prog");
	}
	
	// 달력 만들기
	public static void createCalendar(int year, int month) {
		
		Calendar today = Calendar.getInstance();
		today.set(year, month-1, today.DAY_OF_MONTH);
		
		System.out.println(year+"년 "+month+"월\r\n");
		
		String[] days = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sun" };
		for (String i : days) {
			System.out.printf("%-4s", i);
		}
		System.out.println();

		int gapDay = today.get(Calendar.DAY_OF_WEEK); // 앞 공백

		// 1일 위치 지정
		for (int i = 1; i < gapDay; i++) {
			System.out.printf("%-4s", "");
		}

		// 날짜 출력
		int lastDate = today.getActualMaximum(Calendar.DATE); // 마지막 날짜
		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%-4d", i);
			if ((i + (gapDay - 1)) % 7 == 0) {
				System.out.println();
			}
		}
		
	}

}
