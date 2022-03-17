package com.edu_220317;

import java.util.Scanner;

public class BankAppPr {
	// 1.계좌 생성(번호, 예금액, 예금주)
	// 2.예금(번호, 예금액) -> 최대 금액 10만원
	// 3.출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	// 4.잔액조회
	// 5.종료
	// 9.계좌조회

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
				System.out.println("\t프로그램을 종료합니다.");
				break;
			} else if (menu == 9) {
				showList();
			} else {
				System.out.println("\t잘못 입력하셨습니다. 다시 입력해 주세요.");
			}
		}

		System.out.println("=== End of Program ===");

	} // end of main()

	// 메뉴 출력
	public static void printMenu() {

		String str = "\t---------------\r\n" //
				+ "\t 1. 계좌 생성\r\n" //
				+ "\t 2. 입금\r\n" //
				+ "\t 3. 출금\r\n" //
				+ "\t 4. 잔액 조회\r\n" //
				+ "\t 5. 종료\r\n" //
				+ "\t---------------\r\n" //
				+ "선택 > ";
		System.out.print(str);

	} // end of printMenu()

	// 1. 계좌 생성
	public static void createAccount() {

		System.out.println("\t[1. 계좌 생성]");
		String accNo;

		while (true) {
			System.out.print("생성할 계좌번호 입력 >> ");
			String inputAcc = scan.next();

			int checkCnt = 0;
			for (int i = 0; i < banks.length; i++) {
				if (banks[i] != null && banks[i].getAccNo().equals(inputAcc)) {
					checkCnt = 1;
				}
			}

			if (checkCnt == 1) {
				System.out.println("\t이미 동일한 계좌가 있습니다. 다시 입력해 주세요.");
				continue;
			} else if (checkCnt == 0) {
				accNo = inputAcc;
				break;
			}
		}

		System.out.print("예금주 입력 >> ");
		String accName = scan.next();

		int accMoney;
		while (true) {
			System.out.print("예금액 입력 >> ");
			int money = scan.nextInt();

			if (money > 100000) {
				System.out.println("\t최대 한도는 100,000원입니다. 다시 입력해 주세요.");
			} else if (money < 0) {
				System.out.println("\t잘못 입력하셨습니다. 다시 입력해 주세요.");
			} else {
				accMoney = money;
				break;
			}
		}

		BankAccount acnt = new BankAccount(accNo, accName, accMoney); // 인스턴스 생성

		for (int i = 0; i < banks.length; i++) { // banks 배열에 인스턴스 추가
			if (banks[i] == null) {
				banks[i] = acnt;
				System.out.println("\t새로운 계좌 생성이 완료되었습니다.");
				break;
			}
		}

	} // end of createAccount()

	// 2. 입금
	public static void deposit() {

		System.out.println("\t[2. 입금]");

		while (true) {
			System.out.print("입금할 계좌번호 입력 >> ");
			String inputAcc = scan.next();

			int checkCnt = 0;

			for (int i = 0; i < banks.length; i++) {
				if (banks[i] != null && inputAcc.equals(banks[i].getAccNo())) {
					checkCnt = 1;
				}
			}

			if (checkCnt == 1) {
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && inputAcc.equals(banks[i].getAccNo())) {
						System.out.print("입금할 금액 입력 >> ");
						int inputMoney = scan.nextInt();
						int accMoney = banks[i].getMoney();

						if (accMoney + inputMoney < 100000) {
							banks[i].setMoney(accMoney + inputMoney);
							System.out.println("\t정상적으로 처리되었습니다.");
							System.out.println("\t" + banks[i].getAccNo() + "번 계좌의 현재 잔액 : " //
									+ banks[i].getMoney());
							break;
						} else if (accMoney + inputMoney > 100000) {
							System.out.println("\t최대 한도를 초과하였습니다.");
							System.out.println("\t" + banks[i].getAccNo() + "번 계좌의 현재 잔액 : " //
									+ banks[i].getMoney());
							break;
						}
					}

				}

			} else if (checkCnt == 0) {
				System.out.println("\t해당하는 계좌 번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}

			if (checkCnt == 1) {
				break;
			}
		}

	} // end of deposit()

	// 3. 출금
	public static void withdraw() {

		System.out.println("\t[3. 출금]");

		while (true) {
			System.out.print("출금할 계좌번호 입력 >> ");
			String inputAcc = scan.next();

			int checkCnt = 0;

			for (int i = 0; i < banks.length; i++) {
				if (banks[i] != null && inputAcc.equals(banks[i].getAccNo())) {
					checkCnt = 1;
				}
			}

			if (checkCnt == 1) {
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && inputAcc.equals(banks[i].getAccNo())) {
						System.out.print("출금할 금액 입력 >> ");
						int inputMoney = scan.nextInt();
						int accMoney = banks[i].getMoney();

						if (accMoney - inputMoney >= 0) {
							banks[i].setMoney(accMoney - inputMoney);
							System.out.println("\t정상적으로 처리되었습니다.");
							System.out.println("\t" + banks[i].getAccNo() + "번 계좌의 현재 잔액 : " //
									+ banks[i].getMoney());
							break;
						} else if (accMoney - inputMoney < 0) {
							System.out.println("\t잔액이 부족합니다.");
							System.out.println("\t" + banks[i].getAccNo() + "번 계좌의 현재 잔액 : " //
									+ banks[i].getMoney());
							break;
						}
					}
				}

			} else if (checkCnt == 0) {
				System.out.println("\t해당하는 계좌 번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}

			if (checkCnt == 1) {
				break;
			}
		}

	} // end of withdraw()

	// 4. 잔액 조회
	public static void findAccMoney() {

		System.out.println("\t[4. 잔액 조회]");

		while (true) {
			System.out.print("잔액을 조회할 계좌번호 입력 >> ");
			String inputAcc = scan.next();

			int checkCnt = 0;
			for (int i = 0; i < banks.length; i++) {
				if (banks[i] != null && inputAcc.equals(banks[i].getAccNo())) {
					checkCnt = 1;
				}
			}

			if (checkCnt == 1) {
				for (int i = 0; i < banks.length; i++) {
					if (banks[i] != null && inputAcc.equals(banks[i].getAccNo())) {
						System.out.println("\t" + banks[i].getAccNo() + "번 계좌의 현재 잔액 : " //
								+ banks[i].getMoney());
						break;
					}
				}
			} else if (checkCnt == 0) {
				System.out.println("\t해당하는 계좌번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}

			if (checkCnt == 1) {
				break;
			}
		}

	} // end of findAccMoney()

	// 9. 리스트 조회
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	} // end of showList()
}
