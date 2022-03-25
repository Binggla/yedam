package com.edu.api;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;

public class DateClassTimePkg {

	public static void main(String[] args) {
		
		Date today = new Date("2022/01/01/ 00:00:00");
		System.out.println(today);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		System.out.println(sdf.format(today));
		
		LocalDate lToday = LocalDate.now();
		LocalTime lTime = LocalTime.now();
		System.out.println(lToday);
		System.out.println(lTime);
		
		LocalDateTime time = LocalDateTime.now();
		System.out.println(time.getYear() + "년");

	}

}
