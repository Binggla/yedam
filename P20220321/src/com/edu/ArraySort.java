package com.edu;

import java.util.Scanner;

public class ArraySort {

	static Scanner scan = new Scanner(System.in);

	// 배열 정렬
	public static void arySort(int[] ary) {

		for (int i = 0; i < ary.length; i++) {
			for (int j = i + 1; j < ary.length; j++) {
				if (ary[i] > ary[j]) {
					int temp = ary[j];
					ary[j] = ary[i];
					ary[i] = temp;
				}
			}
		}

	}

	// 배열 출력
	public static void aryPrint(int[] ary) {

		System.out.print("정렬 : ");
		for (int i = 0; i < ary.length; i++) {
			System.out.print(ary[i] + " ");
		}
		System.out.println();

	}

	// main()
	public static void main(String[] args) {

		int[] intAry = { 34, 25, 48, 12 };
		arySort(intAry);
		aryPrint(intAry);

		int[] intAry2 = { 46, 8, 12, 40, 29 };
		arySort(intAry2);
		aryPrint(intAry2);

		scan.close();

	}

}
