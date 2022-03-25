package com.edu_220317;

import java.util.Scanner;

public class BankApp {

	// 1.계좌 생성(번호, 예금액, 예금주)
	// 2.예금(번호, 예금액) -> 최대 금액 10만원
	// 3.출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	// 4.잔액조회
	// 5.송금(송금 계좌번호, 금액, 입금 계좌번호)
	// 6.종료

	static BankAccount[] banks = new BankAccount[100];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		BankAccount accnt = new BankAccount("100", "지수빈", 10000);
		banks[0] = accnt;

		BankAccount accnt1 = new BankAccount("200", "지수빈", 10000);
		banks[1] = accnt1;

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
				transferAmount();
			} else if (menu == 6) {
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
	
	// 메뉴 출력
	public static void printMenu() {
		String menu = "\t-----------------\r\n" //
				+ "\t 1. 계좌 생성\r\n" //
				+ "\t 2. 입금\r\n" //
				+ "\t 3. 출금\r\n" //
				+ "\t 4. 잔액조회\r\n" //
				+ "\t 5. 송금\r\n" //
				+ "\t 6. 종료\r\n" //
				+ "\t-----------------\r\n"//
				+ "선택 > ";
		System.out.print(menu);
	} // end of printMenu()

	// 1. 계좌 생성
	public static void createAccount() {
		System.out.println("\t[1. 계좌 생성]");

		String accNo, accName;
		int accMoney;

		while (true) {
			System.out.print("생성할 계좌번호 입력 >> ");
			String inputNo = scan.next();

			if (searchAccountNo(inputNo) != null) {
				System.out.println("\t이미 동일한 계좌가 있습니다. 다시 입력해 주세요.");
				continue;
			}
			accNo = inputNo;
			break;
		}

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

	// 2. 입금
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

				if (accMoney + inputMoney <= 100000) {
					myAcc.setMoney(accMoney + inputMoney);
					System.out.println("\t입금이 정상적으로 처리되었습니다.");
					System.out.println("\t" + myAcc.getAccNo() + "번 계좌의 현재 잔액 : " //
							+ myAcc.getMoney());
					break;
				} else if (accMoney + inputMoney > 100000) {
					System.out.println("\t최대 한도를 초과하였습니다. 초기 화면으로 돌아갑니다.");
					System.out.println("\t" + myAcc.getAccNo() + "번 계좌의 현재 잔액 : " //
							+ myAcc.getMoney());
					break;
				}
			}
			System.out.println("\t해당하는 계좌 번호가 없습니다. 초기 화면으로 돌아갑니다.\r\n");
			break;
		}

	} // end of deposit()

	// 3. 출금
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

				if (accMoney - inputMoney <= 0) {
					myAcc.setMoney(accMoney - inputMoney);
					System.out.println("\t출금이 정상적으로 처리되었습니다.");
					System.out.println("\t" + myAcc.getAccNo() + "번 계좌의 현재 잔액 : " //
							+ myAcc.getMoney());
					break;
				} else if (accMoney - inputMoney < 0) {
					System.out.println("\t잔액이 부족합니다. 초기 화면으로 돌아갑니다.\r\n");
					System.out.println("\t" + myAcc.getAccNo() + "번 계좌의 현재 잔액 : " //
							+ myAcc.getMoney());
					break;
				}

			}
			System.out.println("\t해당하는 계좌 번호가 없습니다. 초기 화면으로 돌아갑니다.\r\n");
			break;

		}

	} // end of withdraw()

	// 4. 잔액 조회
	public static void findAccMoney() {
		System.out.println("\t[4. 잔액 조회]");

		while (true) {
			System.out.print("잔액을 조회할 계죄번호 입력 >> ");
			String inputNo = scan.next();

			if (searchAccountNo(inputNo) != null) {
				BankAccount myAcc = searchAccountNo(inputNo);
				String str = "\t=================\r\n" //
						+ "\t 계좌번호\t" + myAcc.getAccNo() + "\r\n" //
						+ "\t 예금주\t" + myAcc.getAccName() + "\r\n" //
						+ "\t 현재 금액\t" + myAcc.getMoney() + "\r\n" //
						+ "\t=================\r\n";
				System.out.println(str);
				break;
			}

			System.out.println("\t해당하는 계좌 번호가 없습니다. 초기 화면으로 돌아갑니다.\r\n");
			break;

		}
	} // end of findAccMoney()

	// 5. 송금
	public static void transferAmount() {

		String sendInput, getInput;
		int sendMoney;
		BankAccount sendAcc = null, getAcc = null;

		// 송금 계좌 입력
		while (true) {
			System.out.print("송금 계좌 입력 >> ");
			sendInput = scan.next();

			if (searchAccountNo(sendInput) == null) {
				System.out.println("\t해당하는 계좌를 찾을 수 없습니다.");
			} else {
				sendAcc = searchAccountNo(sendInput);
				break;
			}
		}
			
		// 입금 계좌 입력
		while (true) {
			System.out.print("입금 계좌 입력 >> ");
			getInput = scan.next();

			if (searchAccountNo(getInput) == null) {
				System.out.println("\t해당하는 계좌를 찾을 수 없습니다.");
			} else {
				getAcc = searchAccountNo(getInput);
				break;
			}
		}

		// 송금 금액 입력
		System.out.print("송금액 입력 >> ");
		sendMoney = scan.nextInt();

		int sendAccNow = sendAcc.getMoney();
		int getAccNow = getAcc.getMoney();
		
		if (sendMoney > sendAccNow)	{
			System.out.println("\t잔액이 부족합니다. 초기 화면으로 돌아갑니다.\r\n");
			return;
		} else {
			sendAcc.setMoney(sendAccNow - sendMoney);
			getAcc.setMoney(getAccNow + sendMoney);
			System.out.println("\t송금이 정상적으로 처리되었습니다.");
		}
		
		String str = "\t=================\r\n" //
				+ "\t계좌번호" + "\t현재 금액\r\n" //
				+ "\t" + sendAcc.getAccNo()+ "\t" + sendAcc.getMoney() + "\r\n" //
				+ "\t" + getAcc.getAccNo()+ "\t" + getAcc.getMoney() + "\r\n" //
				+ "\t=================\r\n";
		
		System.out.println(str);
	}

	// 9. 전체 리스트 출력
	public static void showList() {
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null) {
				System.out.println(banks[i].toString());
			}
		}
	} // end of showList()

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
