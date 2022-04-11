package com.edu_220314;

import java.util.Scanner;

public class CashExample {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int price, cash, tax, change;
		
		System.out.println("상품 가격을 입력하세요.");
		price = scn.nextInt();
		System.out.println("받은 금액을 입력하세요.");
		cash = scn.nextInt();
		tax = price / 11;
		change = cash - price;
		
		System.out.println("부가세 : " + tax + "원");
		System.out.println("거스름돈 : " + change + "원");
		
		scn.close();
	}

}
