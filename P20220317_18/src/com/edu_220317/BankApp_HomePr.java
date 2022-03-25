package com.edu_220317;

import java.util.Scanner;

public class BankApp_HomePr {
	// 1.계좌 생성(번호, 예금액, 예금주)
	// 2.예금(번호, 예금액) -> 최대 금액 10만원
	// 3.출금(번호, 출금액) -> 잔액보다 큰 금액 출금 못하도록.
	// 4.잔액조회
	// 5.종료
	// 9.계좌조회

	// 송금 기능 추가 + 명세표

	static BankAccount[] banks = new BankAccount[100];
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		// 이미 존재하는 계좌
		BankAccount a1 = new BankAccount("100", "지수빈", 10000);
		banks[0] = a1;
		BankAccount a2 = new BankAccount("200", "지수빈", 10000);
		banks[1] = a2;

		// 메뉴 출력
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
				sendMoney();
			} else if (menu == 5) {
				findAccMoney();
			} else if (menu == 6) {
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
				+ "\t 4. 송금\r\n" //
				+ "\t 5. 잔액 조회\r\n" //
				+ "\t 6. 종료\r\n" //
				+ "\t---------------\r\n" //
				+ "선택 > ";
		System.out.print(str);

	} // end of printMenu()

	// 1. 계좌 생성
	public static void createAccount() {

		System.out.println("\t[1. 계좌 생성]");

		// 1. 계좌번호 입력
		// 1.1. 동일한 계좌가 없으면 예금주 입력
		// 1.2. 동일한 계좌가 있으면 재입력 요청

		String accNo;
		while (true) {
			System.out.print("생성할 계좌번호 입력 >> ");
			String inputAccNo = scan.next();

			if (searchAccountNo(inputAccNo) == null) {
				accNo = inputAccNo;
				break;
			}
			System.out.println("\t이미 동일한 계좌가 있습니다. 다시 입력해 주세요.");
		}

		// 2. 예금주 입력

		System.out.print("예금주 입력 >> ");
		String accName = scan.next();

		// 3. 예금액 입력
		// 3.1. 예금액 < 0, 예금액 > 100,000일 경우 재입력 요청
		// 3.2. 0 <= 예금액 <= 100,000일 경우 계좌 생성

		int accMoney;
		while (true) {
			System.out.print("예금액 입력 >> ");
			int intMoney = scan.nextInt();

			if (intMoney > 100000) {
				System.out.println("\t최대 한도는 100,000원입니다. 다시 입력해 주세요.");
			} else if (intMoney < 0) {
				System.out.println("\t잘못 입력하셨습니다. 다시 입력해 주세요.");
			} else {
				accMoney = intMoney;
				break;
			}
		}

		// 4. 계좌 생성
		// 4.1. BankAccount 인스턴스를 생성하여 banks 배열에 저장
		// 4.2. 배열이 가득찼을 경우 생성 불가

		BankAccount newAcc;
		for (int i = 0; i < banks.length; i++) { // banks 배열에 인스턴스 추가
			if (banks[i] == null) {
				newAcc = new BankAccount(accNo, accName, accMoney);
				banks[i] = newAcc;
				System.out.println("\t계좌 생성이 정상적으로 처리되었습니다.\r\n");
				break;
			} else {
				System.out.println("새로운 계좌를 더이상 생성할 수 없습니다.\r\n");
			}
		}

	} // end of createAccount()

	// 2. 입금
	public static void deposit() {

		System.out.println("\t[2. 입금]");

		// 1. 입금 계좌번호 입력
		// 1.1. 입력된 계좌번호가 조회되지 않을 경우 계좌번호 재입력 요청
		// 1.2. 입력된 계좌번호가 조회될 경우 입금 금액 입력

		while (true) {
			System.out.print("입금 계좌번호 입력 >> ");
			String inputAccNo = scan.next();

			if (searchAccountNo(inputAccNo) == null) {
				System.out.println("\t해당하는 계좌번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}

			BankAccount findAcc = searchAccountNo(inputAccNo);
			
		// 2. 입금 금액 입력
		// 2.1. 입금 완료 시 명세표 출력
		// 2.2. 입금 시 최대 한도를 초과하면 입금을 취소하고 메뉴로 이동

			System.out.print("입금 금액 입력 >> ");
			int inputMoney = scan.nextInt();
			int accMoney = findAcc.getMoney();
			int accMoneyTotal = accMoney + inputMoney;

			if (0 <= accMoneyTotal && accMoneyTotal <= 100000) {
				findAcc.setMoney(accMoneyTotal);
				System.out.println("\t입금이 정상적으로 처리되었습니다.");
				printBill(findAcc.getAccNo(), findAcc.getMoney());
				break;
			} else if (accMoneyTotal > 100000) {
				System.out.println("\t최대 한도를 초과하였습니다. 메인 화면으로 돌아갑니다.\r\n");
				break;
			}
		}

	} // end of deposit()

	// 3. 출금
	public static void withdraw() {

		System.out.println("\t[3. 출금]");

		// 1. 출금 계좌번호 입력
		// 1.1. 입력된 계좌번호가 조회되지 않을 경우 계좌번호 재입력 요청
		// 1.2. 입력된 계좌번호가 조회될 경우 출금 금액 입력

		while (true) {
			System.out.print("출금 계좌번호 입력 >> ");
			String inputAccNo = scan.next();

			if (searchAccountNo(inputAccNo) == null) {
				System.out.println("\t해당하는 계좌번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}

			BankAccount findAcc = searchAccountNo(inputAccNo);
			
		// 2. 출금 금액 입력
		// 2.1. 출금 완료 시 명세표 출력
		// 2.2. 출금액이 현재 잔액보다 클 경우 출금을 취소하고 메뉴로 이동

			System.out.print("출금 금액 입력 >> ");
			int inputMoney = scan.nextInt();
			int accMoney = findAcc.getMoney();
			int accMoneyTotal = accMoney - inputMoney;

			if (0 <= accMoneyTotal && accMoneyTotal <= 100000) {
				findAcc.setMoney(accMoneyTotal);
				System.out.println("\t출금이 정상적으로 처리되었습니다.");
				printBill(findAcc.getAccNo(), findAcc.getMoney());
				break;
			} else if (accMoneyTotal < 0) {
				System.out.println("\t잔액이 부족합니다. 메인 화면으로 돌아갑니다.\r\n");
				break;
			}
		}

	} // end of withdraw()

	// 4. 송금
	public static void sendMoney() {
		
		// 1. 송금 계좌 조회
		// 1.1. 입력된 계좌번호가 조회되지 않을 경우 계좌번호 재입력 요청
		// 1.2. 입력된 계좌번호가 조회될 경우 입금 계좌 조회
		
		System.out.println("\t[4. 송금]");
		
		BankAccount sendAcc = null, getAcc = null;
		
		while (true) {
			System.out.print("송금 계좌번호 입력 >> ");
			String inputAccNo = scan.next();
			
			if (searchAccountNo(inputAccNo) == null) {
				System.out.println("\t해당하는 계좌번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}
			sendAcc = searchAccountNo(inputAccNo);
			break;
		}
		
		// 2. 입금 계좌 조회
		// 2.1. 입력된 계좌번호가 조회되지 않을 계좌번호 재입력 요청
		// 2.2. 입력된 계좌번호가 송금 계좌번호와 동일할 경우 계좌번호 재입력 요청
		// 2.3. 입력된 계좌번호가 조회될 경우 입금액 입력
		
		while (true) {
			System.out.print("입금 계좌번호 입력 >> ");
			String inputAccNo = scan.next();
			if (searchAccountNo(inputAccNo) == null) {
				System.out.println("\t해당하는 계좌번호가 없습니다. 다시 입력해 주세요.");
				continue;
			} else if (searchAccountNo(inputAccNo) == sendAcc) {
				System.out.println("\t송금 계좌와 동일한 계좌번호를 입력하였습니다. 다시 입력해 주세요.");
				continue;
			}
			getAcc = searchAccountNo(inputAccNo);
			break;
		}
		
		// 3. 입금액 입력
		// 3.1. 0 >= 입금 계좌 + 입금액 >= 100000일 경우 입금 완료 후 명세표 출력
		// 3.2. 입금 계좌 + 입금액 > 100000일 경우 최대 한도 초과로 메뉴 이동
		
		System.out.print("입금액 입력 >> ");
		int inputMoney = scan.nextInt();
		
		int sendAccMoney = sendAcc.getMoney();
		int getAccMoney = getAcc.getMoney();
		int sendAccTotal = sendAccMoney - inputMoney;
		int getAccTotal = getAccMoney + inputMoney;
		
		if (0 <= getAccTotal && getAccTotal <= 100000) {
			sendAcc.setMoney(sendAccTotal);
			getAcc.setMoney(getAccTotal);
			
			System.out.println("\t송금이 정상적으로 처리되었습니다.");
			printBill(sendAcc.getAccNo(), getAcc.getAccNo(), sendAcc.getMoney(), getAcc.getMoney());
			
		} else if (getAccTotal > 100000) {
			System.out.println("\t최대 한도를 초과하여 송금을 할 수 없습니다. 메인 화면으로 돌아갑니다.");
		}
		
	}
	
	
	// 5. 잔액 조회
	public static void findAccMoney() {

		// 1. 잔액을 조회할 계좌번호를 입력
		// 1.1. 입력된 계좌번호가 조회되지 않을 경우 계좌번호 재입력 요청
		// 1.2. 입력된 계좌번호가 조회될 경우 잔액 조회

		System.out.println("\t[5. 잔액 조회]");

		while (true) {
			System.out.print("조회 계좌번호 입력 >> ");
			String inputAccNo = scan.next();

			if (searchAccountNo(inputAccNo) == null) {
				System.out.println("\t해당하는 계좌번호가 없습니다. 다시 입력해 주세요.");
				continue;
			}
			
			BankAccount findAcc = searchAccountNo(inputAccNo);
			
		// 2. 잔액 조회
			
			String str = "\t===============\r\n" //
					+ "\t 계좌번호\t" + "잔액\r\n" //
					+ "\t " + findAcc.getAccNo() + "\t" + findAcc.getMoney() + "\r\n" //
					+ "\t===============\r\n"; //
			System.out.println(str);
			break;
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

	
	// 명세표 출력
	public static void printBill(String acc, int accMoney) {
		System.out.print("\t명세표를 출력하시겠습니까? (Y/N) >>> ");
		String inputAnswer = scan.next();
		
		if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {
			String str = "\t===============\r\n" //
					+ "\t 계좌번호\t" + "잔액\r\n" //
					+ "\t " + acc + "\t" + accMoney + "\r\n" //
					+ "\t==============="; //
			System.out.println(str);
			
		} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
			System.out.println("\t메인 화면으로 돌아갑니다.");
		}
	} // end of printBill()
	
	// 명세표 출력
	public static void printBill(String sendAcc, String getAcc, int sendAccTotal, int getAccTotal) {
		System.out.print("\t명세표를 출력하시겠습니까? (Y/N) >>> ");
		String inputAnswer = scan.next();
		
		if (inputAnswer.equals("Y") || inputAnswer.equals("y")) {
			String str = "\t===============\r\n" //
					+ "\t 계좌번호\t" + "잔액\r\n" //
					+ "\t " + sendAcc + "\t" + sendAccTotal + "\r\n" //
					+ "\t " + getAcc + "\t" + getAccTotal + "\r\n" //
					+ "\t===============\r\n"; //
			System.out.println(str);
			
		} else if (inputAnswer.equals("N") || inputAnswer.equals("n")) {
			System.out.println("\t메인 화면으로 돌아갑니다.\r\n");
		}
	} // end of printBill()

	// 계좌번호 조회
	public static BankAccount searchAccountNo(String accNo) {
		
		// 계좌번호를 입력했을 때 배열에서 동일한 계좌번호를 반환. 아니면 null을 반환.
		
		for (int i = 0; i < banks.length; i++) {
			if (banks[i] != null && accNo.equals(banks[i].getAccNo())) {
				return banks[i];
			}
		}
		return null;
	}

}





























