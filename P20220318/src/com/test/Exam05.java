package com.test;

import java.util.Scanner;

// 문제5) Book클래스를 선언(필드:책제목, 저자, 출판사, 금액) 
//      생성자(책제목, 저자, 출판사, 금액)를 선언 후 Scanner클래스를 사용하여 사용자의 입력을 통하여 인스턴스를 생성하고 
//      입력한 내용을 책제목, 저자, 출판사, 금액 정보를 화면에 출력하는 기능 구현.

	
public class Exam05 {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
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
		
		Book b1 = new Book(inTitle, inWriter, inPub, inPrice);
		System.out.println("\n정보가 입력되었습니다. 아래 내용을 확인해 주세요.");
		
		b1.printInfo();
		
		
	}
	
	

}

