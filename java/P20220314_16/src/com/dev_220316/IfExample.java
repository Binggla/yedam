package com.dev_220316;

public class IfExample {	//WhichExample

	public static void main(String[] args) {
		// 조건문 if
		
		int score = 97;
		
		if (score >= 60) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		
		if (score >= 90) {
			if (score >= 95) {
				System.out.println("A+");
			} else {
				System.out.println("A");
			}
		} else if (score >= 80) {
			if (score >= 85) {
				System.out.println("B+");
			} else {
				System.out.println("B");
			}
		} else if (score >= 70) {
			if (score >= 75) {
				System.out.println("C+");
			} else {
				System.out.println("C");
			}
		} else if (score >= 60) {
			if (score >= 65) {
				System.out.println("D+");
			} else {
				System.out.println("D");
			}
		} else {
			System.out.println("F");
		}
		
		System.out.println("<end of Program>");

	}

}
