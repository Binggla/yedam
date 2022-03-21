package Baekjoon;

import java.util.Scanner;

public class If_5 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int h = scan.nextInt();
		int m = scan.nextInt();

		if (m - 45 < 0) {
			h = h - 1;
			m = m + 15;
			if (h == -1) {
				h = 23;
			}
		} else if (m - 45 >= 0) {
			m = m - 45;
		}

		System.out.println(h + " " + m);

	}

}
