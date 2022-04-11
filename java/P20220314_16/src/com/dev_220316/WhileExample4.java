package com.dev_220316;

import java.util.Scanner;

class Bill {
	int account;
	void billPrint() {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.print("명세표를 출력하시겠습니까? (Y/N) > ");
			String inputAnswer = scan.nextLine();

			if (inputAnswer.equals("Y")) {
				System.out.println("--------------------");
				System.out.println("현재 잔액 : " + account);
				System.out.println("--------------------");
				System.out.println("감사합니다. 좋은 하루 되십시오.");
				break;
			} else if (inputAnswer.equals("N")) {
				System.out.println("감사합니다. 좋은 하루 되십시오.");
				break;
			} else {
				System.out.println("잘못 누르셨습니다.");
				continue;
			}
		}
		scan.close();
	}
}

public class WhileExample4 {

	public static void main(String[] args) {
		// 1:입금, 2:출금, 3:종료 프로그램 만들기

		int menu = 0;
		
		Scanner scan = new Scanner(System.in);
		Bill bill = new Bill();


		while (true) {
			System.out.println("-----------------");
			System.out.println("1:입금 2:출금 3:종료");
			System.out.println("-----------------");
			menu = scan.nextInt();

			if (menu == 1) {
				System.out.print("입금액 >> ");
				bill.account += scan.nextInt();
				System.out.println("현재 잔액 >>> " + bill.account);
			} else if (menu == 2) {
				System.out.print("출금액 >> ");
				int minus = scan.nextInt();
				if (minus > bill.account) {
					System.out.println("잔액이 부족합니다.");
					continue;
				}
				bill.account -= minus;
				System.out.println("현재 잔액 >>> " + bill.account);
			} else if (menu == 3) {
				bill.billPrint();
				break;
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 선택하세요.");
			}

//			switch (menu) {
//			case 1:
//				System.out.println("입금액을 입력하세요.");
//				int plus = scan.nextInt();
//				account += plus;
//				System.out.println("현재 잔액은 " + account + "원입니다.");
//				continue;
//			case 2:
//				System.out.println("출금액을 입력하세요.");
//				int minus = scan.nextInt();
//				account -= minus;
//				System.out.println("현재 잔액은 " + account + "원입니다.");
//				continue;
//			case 3:
//				System.out.println("현재 잔액은 " + account + "원입니다.");
//				System.out.println("시스템이 종료되었습니다.");
//				break;
//			default:
//				System.out.println("잘못 입력하셨습니다. 다시 선택하세요.");
//			}

		}

		System.out.println("End of Program");

		scan.close();
	}

}
