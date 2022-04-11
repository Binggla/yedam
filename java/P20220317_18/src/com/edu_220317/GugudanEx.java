package com.edu_220317;

public class GugudanEx {

	public static void main(String[] args) {
		
//		for(int i = 1; i <= 10; i++) {
//			printStar(i, "★");
//			System.out.println();
//		}
		
		int[] newAry = { 10, 20, 30 };
		int result = sum(newAry);
		System.out.println("배열의 합 : " + result);
		
	} // end of main()

	public static int sum(int[] ary) {
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		return sum;
	}
	
	public static double division(double a, double b) {
		if (a == 0) { a = 0; } 
		else if (b == 0) { b = 0;}
		return a / b;
	}
	
	public static int sum(int a, int b) {
		return a + b;
		}
	
	public static void gugudan(int dan) {
		System.out.println("    [" + dan + "단]");
		for (int i = 1; i <= 9; i++) {
			System.out.printf("%2d * %2d = %2d\n", dan, i, dan*i);
		}
	}
	
	public static void printStar(int runCnt, String runShape) {
		for (int i = 0; i < runCnt; i++) {
			System.out.print(runShape);
		}
		
	} // end of printStar()
	
	public static void printGugudan() {
		
		for (int i = 2; i <= 5; i++) {
			int cnt = i;
			System.out.print("[" + cnt + "단]\t");
		}
		System.out.println();
		for (int i = 1; i <= 9; i++) { // 중첩 for문
			for (int j = 2; j <= 5; j++) {
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
		
	} // end of printGugudan()
	
}