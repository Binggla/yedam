package com.edu_220317;

import java.util.Scanner;

public class BankApp_Pr {

	// 1.계좌 생성(번호, 예금액, 예금주)
	// 2.예금(번호, 예금액) -> 최대 금액 10만원
	// 3.출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	// 4.잔액조회
	// 5.종료

	static BankAccount[] banks = new BankAccount[100];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		BankAccount accnt = new BankAccount("100", "지수빈", 0);
		banks[0] = accnt;
		
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
		System.out.println("\t[1. 계좌 생성]");

		String accNo, accName;
		int accMoney;

	
		System.out.print("생성할 계좌번호 입력 >> ");
		String inputNo = scan.next();

		if (searchAccountNo(inputNo) != null) {
			System.out.println("\t이미 동일한 계좌가 있습니다. 다시 입력해 주세요.");
			return;
		}
		accNo = inputNo;

		System.out.print("예금주 입력 >> ");
		accName = scan.next();

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

		System.out.println("\t[2. 입금]");

		while (true) {
			System.out.print("입금할 계좌번호 입력 >> ");
			String inputNo = scan.next();

			if (searchAccountNo(inputNo) != null) {
				System.out.print("입금할 금액 입력 >> ");
				int inputMoney = scan.nextInt();

				BankAccount myAcc = searchAccountNo(inputNo);
				int accMoney = myAcc.getMoney();
				int plusMoney = accMoney + inputMoney;

				if (plusMoney <= 100000) {
					myAcc.setMoney(plusMoney);
					System.out.println("\t입금이 정상적으로 처리되었습니다.");
					printPlusBill(accMoney, inputMoney, plusMoney);
					break;
				} else if (plusMoney > 100000) {
					System.out.println("\t최대 한도를 초과하였습니다. 초기 화면으로 돌아갑니다.");
					System.out.println("\t" + myAcc.getAccNo() + "번 계좌의 현재 잔액 : " //
							+ myAcc.getMoney());
					break;
				}
			}
			System.out.println("\t해당하는 계좌 번호가 없습니다. 초기 화면으로 돌아갑니다.");
			break;
		}

	} // end of deposit()

	// 출금
	public static void withdraw() {

		System.out.println("\t[3. 출금]");

		while (true) {

			System.out.print("출금할 계좌번호 입력 >> ");
			String inputNo = scan.next();

			if (searchAccountNo(inputNo) != null) {
				System.out.print("출금할 금액 입력 >> ");
				int inputMoney = scan.nextInt();

				BankAccount myAcc = searchAccountNo(inputNo);
				int accMoney = myAcc.getMoney();
				int minusMoney = accMoney - inputMoney;

				if (minusMoney >= 0) {
					myAcc.setMoney(minusMoney);
					System.out.println("\t출금이 정상적으로 처리되었습니다.");
					printMinusBill(accMoney, inputMoney, minusMoney);
					break;
				} else if (accMoney < inputMoney) {
					System.out.println("\t잔액이 부족합니다. 초기 화면으로 돌아갑니다.");
					System.out.println("\t" + myAcc.getAccNo() + "번 계좌의 현재 잔액 : " //
							+ myAcc.getMoney());
					break;
				}

			}
			System.out.println("\t해당하는 계좌 번호가 없습니다. 초기 화면으로 돌아갑니다.");
			break;

		}

	} // end of withdraw()

	// 잔액 조회
	public static void findAccMoney() {
		System.out.println("\t[4. 잔액 조회]");

		while (true) {
			System.out.print("잔액을 조회할 계좌번호 입력 >> ");
			String inputNo = scan.next();

			if (searchAccountNo(inputNo) != null) { 
				BankAccount myAcc = searchAccountNo(inputNo);
				String str = "\t=================\r\n" //
						+ "\t 계좌 번호\t" + myAcc.getAccNo() + "\r\n" //
						+ "\t 예금주\t"+ myAcc.getAccName() + "\r\n" //
						+ "\t 잔액\t" + myAcc.getMoney() + "\r\n" //
						+ "\t=================\r\n";
				System.out.println(str);
				break;
			}

			System.out.println("\t해당하는 계좌 번호가 없습니다. 초기 화면으로 돌아갑니다.");
			break;

		}
	} // end of findAccMoney()

	// 전체 리스트 출력
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	}

	// 명세표 출력
	public static void printPlusBill(int accMoney, int inputMoney, int plusMoney) {
		System.out.println("명세표를 출력하시겠습니까? (Y/N)");
		String inputAnswer = scan.next();
		
		if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {
			String str = "\t=================\r\n" //
					+ "\t 원금\t" + accMoney + "원\r\n" //
					+ "\t 입금액\t" + inputMoney + "원\r\n" //
					+ "\t 잔액\t" + plusMoney + "원\r\n" //
					+ "\t=================\r\n";
			System.out.println(str);
		} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
			System.out.println("\t초기 화면으로 돌아갑니다.");
		} else {
			System.out.println("\t잘못 입력하셨습니다. 다시 입력해 주세요.");
		}
	}
	
	public static void printMinusBill(int accMoney, int inputMoney, int minusMoney) {
		System.out.println("명세표를 출력하시겠습니까? (Y/N)");
		String inputAnswer = scan.next();
		
		if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {
			String str = "\t=================\r\n" //
					+ "\t 원금\t" + accMoney + "원\r\n" //
					+ "\t 출금액\t" + inputMoney + "원\r\n" //
					+ "\t 잔액\t" + minusMoney + "원\r\n" //
					+ "\t=================\r\n";
			System.out.println(str);
		} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
			System.out.println("\t초기 화면으로 돌아갑니다.");
		} else {
			System.out.println("\t잘못 입력하셨습니다. 다시 입력해 주세요.");
		}
	}
	

	// 계좌번호를 입력했을 때 배열에서 동일한 계좌번호를 반환. 아니면 null을 반환.
	public static BankAccount searchAccountNo(String accNo) {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && accNo.equals(banks[i].getAccNo())) {
				return banks[i];
			}
		}
		return null;
	}

}
