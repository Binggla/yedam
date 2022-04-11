package com.test;

import java.util.Scanner;

// 문제5) Book클래스를 선언(필드:책제목, 저자, 출판사, 금액) 
//      생성자(책제목, 저자, 출판사, 금액)를 선언 후 Scanner클래스를 사용하여 사용자의 입력을 통하여 인스턴스를 생성하고 
//      입력한 내용을 책제목, 저자, 출판사, 금액 정보를 화면에 출력하는 기능 구현.

	
public class Exam6 {
	
	static Scanner scan = new Scanner(System.in);
	static Book[] books = new Book[100];
	
	public static void main(String[] args) {
		
		
		while (true) {
			
			printMenu();
			int inputAnswer = scan.nextInt();
			
			if(inputAnswer == 1) {
				inputInfo();
			} else if (inputAnswer == 2) {
				printInfo();
			} else if (inputAnswer == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		System.out.println("----End of Program----");
	}
	
	public static void printMenu()	{
		String str = "------------------\n" //
				+ " 1. 책 정보 입력\n" //
				+ " 2. 책 조회\n" //
				+ " 3. 종료\n" //
				+ "------------------\n"
				+ " 선택 > ";
		System.out.print(str);
	}
	
	public static void inputInfo()	{
		
		String inTitle, inWriter, inPub;
		int inPrice;
		
		System.out.print("책 제목을 입력하세요 > ");
		inTitle = scan.next();
		System.out.print("저자를 입력하세요 > ");
		inWriter = scan.next();
		System.out.print("출판사를 입력하세요 > ");
		inPub = scan.next();
		System.out.print("금액을 입력하세요 > ");
		inPrice = scan.nextInt();
		
		Book b = new Book(inTitle, inWriter, inPub, inPrice);
		
		for (int i = 0; i < books.length; i++) {
			if (books[i] == null) {
				books[i] = b;
				break;
			}
		}
		
		System.out.println("정보가 입력되었습니다.");
	}
	
	public static void printInfo() {
		
		System.out.print("조회할 책 이름 입력 >> ");
		String inTitle = scan.next();
		
		if (searchBook(inTitle) == null) {
			System.out.println("조회되는 책이 없습니다.");
			return;
		}

		Book book = searchBook(inTitle);
		String str = "------------------\n" //
				+ " 제목\t" + book.getbTitle() + "\n" //
				+ " 저자\t" + book.getbWriter() + "\n" //
				+ " 출판사\t" + book.getbPub() + "\n" //
				+ " 금액\t" + book.getbPrice() + "\n" //
				+ "------------------";
		System.out.println(str);
	}
	
	public static Book searchBook(String inTitle) {
		for (int i = 0; i < books.length; i++) {
			if (books[i] != null && inTitle.equals(books[i].getbTitle())) {
				return books[i];
			}
		}
		return null;
	}
	
}

