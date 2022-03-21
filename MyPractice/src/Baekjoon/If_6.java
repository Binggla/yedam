package Baekjoon;

import java.util.Scanner;

public class If_6 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int hour = scan.nextInt();
		int min = scan.nextInt();
		int cookTotalMin = scan.nextInt();

		int cookHour = cookTotalMin / 60;
		int cookMin = cookTotalMin % 60;
		
		int plusHour = hour + cookHour;
		int plusMin = min + cookMin;
		
		
		if (plusMin > 60) {
			hour = (plusHour + 1) % 24;
			min = plusMin - 60;
		} else if (plusMin == 60) {
			hour = (plusHour + 1) % 24;
			min = 0;
		} else if (plusMin < 60) {
			hour = plusHour % 24;
			min = plusMin;
		}


		System.out.println(hour + " " + min);
	}

}
