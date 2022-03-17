package com.edu_220317;

import java.util.Scanner;

public class BankApp {

	// 1.계좌 생성(번호, 예금액, 예금주)
	// 2.예금(번호, 예금액) -> 최대 금액 10만원
	// 3.출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	// 4.잔액조회
	// 5.종료

	static BankAccount[] banks = new BankAccount[100];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {

			printMenu();
			int menu = scan.nextInt();

			if (menu == 1) {
				createAccount();
			} else if (menu == 2) {
				deposit();
			} else if (menu == 3) {
				withdraw();
			} else if (menu == 4) {
				findAccMoney();
			} else if (menu == 5) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (menu == 9) {
				showList();
			} else {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			}
		}
		System.out.println("--- end of program ---");
	} // end of Main()

	public static void printMenu() {
		String menu = "\t-----------------\r\n" //
				+ "\t 1. 계좌 생성\r\n" //
				+ "\t 2. 입금\r\n" //
				+ "\t 3. 출금\r\n" //
				+ "\t 4. 잔액조회\r\n" //
				+ "\t 5. 종료\r\n" + "\t-----------------\r\n"//
				+ "선택 > ";
		System.out.print(menu);
	} // end of printMenu()

	// 계좌 생성
	public static void createAccount() {
		System.out.println("\t[계좌 생성]");
		System.out.print("계좌 번호 입력 >> ");
		String accNo = scan.next();
		System.out.print("예금주 입력 >> ");
		String accName = scan.next();
		int accMoney;
		while (true) {
			System.out.print("예금액 입력 >> ");
			int inputMoney = scan.nextInt();
			if (inputMoney > 100000) {
				System.out.println("예금이 가능한 최대 금액은 10만원입니다. 다시 입력해주세요.");
				continue;
			} else if (inputMoney < 0) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
				continue;
			} else {
				accMoney = inputMoney;
				break;
			}
		}

		BankAccount accnt = new BankAccount(accNo, accName, accMoney);
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] == null) {
				banks[i] = accnt;
				break;
			}
		}
		System.out.println("계좌가 정상적으로 생성되었습니다.");

	} // end of createAccount()

	// 입금
	public static void deposit() {
		System.out.println("\t[입금]");
		System.out.print("계좌번호를 입력하세요. >> ");
		String aNo = scan.next();
		System.out.println("입금할 금액을 입력하세요. >> ");
		int amt = scan.nextInt();

		int checkCnt = 0;	// 제대로 조회가 되었는 지 체크하는 변수. for문 안의 if문을 만족하지 못하면 0으로 계속 진행.
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && banks[i].getAccNo().equals(aNo)) {
				
				checkCnt = 1;	// if문을 제대로 빠져나가면 1로 다음 if에 들어감.
				int currAmt = banks[i].getMoney();
				
				if (currAmt + amt > 100000) {	// 입금액을 더했을 때 10만원이 넘으면
					checkCnt = 2;	// checkCnt = 2로 변경되며 다음 if문으로 계속 진행.
					break;			
				}
				banks[i].setMoney(currAmt + amt);	// 현재 잔액 + 입금액
				break;
			}
		}
		if (checkCnt == 1) {	// for-if를 만족하여 빠져나왔을 경우
			System.out.println("정상적으로 처리되었습니다.");
		} else if (checkCnt == 2) {		// for-if-if를 만족하여 빠져나왔을 경우
			System.out.println("한도액을 초과하였습니다.");
		} else {	// if문을 만족하지 못했을 경우
			System.out.println("해당하는 계좌번호가 없습니다.");
		}

	} // end of deposit()

	// 출금
	public static void withdraw() {
		System.out.println("출금");
	} // end of withdraw()

	// 잔액 조회
	public static void findAccMoney() {
		System.out.println("잔액조회");
	} // end of findAccMoney()

	// 전체 리스트 출력
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
		
	}
}
