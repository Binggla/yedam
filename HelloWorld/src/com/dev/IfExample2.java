package com.dev;

import java.util.Scanner;

public class IfExample2 {

	public static void main(String[] args) {
		// 물건 가격이 50000원 이상이면 배송비 0원, 그 외에는 배송비 3000원을 더하여 총 결제 금액을 출력.
		
		Scanner scn = new Scanner(System.in);
		int price;
		int shippingFee = 3000;
		
		System.out.println("물건의 가격을 입력하세요.");
		price = scn.nextInt();
		
//		if (price >= 50000) {
//			price = price;
//		} else {
//			price = price + shippingFee;
//		}
		
		// 위의 if-else문을 아래처럼 삼항 연산자로도 표현할 수 있다.
		price = (price >= 50000) ? price : (price + shippingFee);
		
		System.out.println("결제할 금액은 " + price + "원입니다.");
		
		scn.close();

	}

}
