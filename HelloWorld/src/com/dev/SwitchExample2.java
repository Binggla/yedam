package com.dev;

public class SwitchExample2 {

	public static void main(String[] args) {
		// 90점 이상 A, 80점 이상 B, 70점 이상 C, 60점 이상 D, 그 외 F

		int score = 100;
	
		
		switch (score/10) {
		case 10:
			System.out.println("A++");
			break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		case 5:
			System.out.println("E");
		}
	}

}
