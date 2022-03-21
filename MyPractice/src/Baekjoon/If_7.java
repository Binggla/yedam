package Baekjoon;

import java.util.Scanner;

public class If_7 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int num1 = scan.nextInt();
		int num2 = scan.nextInt();
		int num3 = scan.nextInt();
		int money = 0;
		
		int[] num = { num1, num2, num3 };
		int max = 0;
		if (num1 == num2 && num2 == num3) {
			money = 10000 + num1 * 1000;
		} else if (num1 == num2 || num2 == num3) {
			money = 1000 + num2 * 100;
		} else if (num1 == num3) {
			money = 1000 + num3 * 100;
		} else if (num1 != num2 && num2 != num3 && num1 != num3) {
			for(int i = 1; i < num.length; i++) {
				max = num[0];
				if (max < num[i]) {
					max = num[i];
					break;
				}
			}
			money = max * 100;
			
		}
		
		System.out.println(money);
	}

}
