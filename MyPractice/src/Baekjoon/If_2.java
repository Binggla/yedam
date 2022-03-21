package Baekjoon;

import java.util.Scanner;

public class If_2 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		
		scan.close();
		
		if (90 <= score && score <= 100) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else if (score > 0) {
			System.out.println("F");
		}

	}

}
