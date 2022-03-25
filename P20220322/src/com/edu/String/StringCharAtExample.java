package com.edu.String;

import java.util.Scanner;

public class StringCharAtExample {

	public static void main(String[] args) {

		IDCheck idcheck = new IDCheck();

		idcheck.checkIdNum();
	}

}

class IDCheck {

	public String checkIdNum() {
		Scanner scan = new Scanner(System.in);

		String inputNum = null;
		while (true) {
			System.out.print("주민등록번호를 입력하세요 > ");
			inputNum = scan.nextLine();
			String rInputNum = inputNum.replace("-", "");
			rInputNum = rInputNum.replace(" ", "");

			if (rInputNum.length() < 13 && inputNum.length() > 15) {
				System.out.println("번호 13자리를 입력해 주세요.");
				continue;
			} else if (rInputNum.length() == 13) {
				System.out.println("입력이 완료되었습니다.");
				System.out.println(getGender(rInputNum));
				break;
			}
		}
		return inputNum;
	}

	public String getGender(String inputNum) {

		String result = null;
		char idNum = inputNum.charAt(6);
		
		switch (idNum) {
		case '1':
		case '3':
			result = "남자입니다.";
		case '2':
		case '4':
			result = "여자입니다.";
		}

		return result;

	}

}
