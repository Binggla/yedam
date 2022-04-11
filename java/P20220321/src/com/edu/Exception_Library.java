package com.edu;

import java.util.InputMismatchException;
import java.util.Scanner;

class Book {
	private String title;
	private String author;
	private int price;

	public Book(String title, String author, int price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public void showInfo() {
		System.out.println("================");
		System.out.println(" 제목\t" + this.title);
		System.out.println(" 저자\t" + this.author);
		System.out.println(" 가격\t" + this.price);
		System.out.println("================");
	}
}

public class Exception_Library {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Book[] library = new Book[5];

		while (true) {
			int menu = 0;

			while (true) {
				try {
					showMsg("1 책 정보 입력 | 2 리스트 보기 | 3 종료   선택 > ");
					menu = scan.nextInt();
					break;
				} catch (InputMismatchException e) {
					System.out.println("숫자를 입력하세요.");
					scan.next();
				}
			}

			if (menu == 1) {
				showMsg("책 제목 입력 >> ");
				String title = scan.next();
				showMsg("저자 입력 >> ");
				String author = scan.next();
				int price = 0;
				while (true) {
					try {
						showMsg("가격 입력 >> ");
						price = scan.nextInt();
						break;
					} catch (InputMismatchException e) {
						System.out.println("숫자를 입력하세요.");
						scan.next();
					}
				}

				Book book = new Book(title, author, price);
				for (int i = 0; i < library.length; i++) {
					if (library[i] == null) {
						library[i] = book;
						break;
					}
				}
				showMsg("[저장 완료]\n");

			} else if (menu == 2) {
				for (int i = 0; i < library.length; i++) {
					if (library[i] != null) {
						library[i].showInfo();
						break;
					}
				}

			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

		System.out.println("<End of Program>");
	}

	public static void showMsg(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i));
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
