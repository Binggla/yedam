package Baekjoon;

import java.util.Scanner;

public class If_3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int year = scan.nextInt();
		scan.close();
		
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			System.out.println(1);
		} else { 
			System.out.println(0);
		}
	}

}
