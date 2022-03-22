package com.edu.api;

public class SystemExample {

	public static void main(String[] args) {

		System.out.println("start");
//		System.exit(0);
		System.out.println("end");
		
		long currentTime = System.currentTimeMillis();
		System.out.println(currentTime); // 1647936714942
		// 24*60*60*1000 : 하루의 millisecond
		
		long days = currentTime / (24*60*60*1000);
		System.out.println(days); // 19073
		long years = days / 365;
		System.out.println(years);
		
		currentTime = System.currentTimeMillis();
		long sum = 0;
		for (int i = 0; i < 1000000; i++) {
			sum += i;
		}
		System.out.println("Summary : " + sum);
		long endTime = System.currentTimeMillis();
		
		System.out.println("연산에 걸린 시간 : " + (endTime - currentTime));
	}

}
