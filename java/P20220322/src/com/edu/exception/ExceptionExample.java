package com.edu.exception;

public class ExceptionExample {

	public static void main(String[] args) {


		String str = null;
		try {
			str.charAt(0);
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("널포인터 예외 발생.");
			e.printStackTrace();
		}
		
		String nums1 = "100";
		String nums2 = "200";
		int num1 = Integer.parseInt(nums1);
		int num2 = Integer.parseInt(nums2);
		System.out.println(num1 + "+" + num2 + "=" + (num1+num2));

	}

}
