package com.edu_220317;

import java.util.Scanner;

public class ArraySort {

	public static void main(String[] args) {
		// int[] intAry => {34, 25, 48, 12};

		Scanner scan = new Scanner(System.in);
		int[] intAry = new int[4];
		
		for (int i = 0; i < intAry.length; i++) {
			System.out.print("정수 입력 > ");
			int inputNum = scan.nextInt();
			intAry[i] = inputNum;
		}
		
		for (int i = 0; i < intAry.length; i++) {
			for (int j = i+1; j < intAry.length; j++) {
				if (intAry[i] > intAry[j]) {
					int temp = intAry[j];
					intAry[j] = intAry[i];
					intAry[i] = temp;
				}
			}
		}
		System.out.print("정렬 : ");
		for (int i = 0; i < intAry.length; i++) {
			System.out.print(intAry[i] + " ");
		}
		

		
		

	}

}
