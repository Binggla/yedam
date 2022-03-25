package com.edu_220314;

public class BitExample {

	public static void main(String[] args) {
		
		int num = 10;					// 대입 연산자(=)
		int result = num << 3;			// 비트 연산자(<<, >>)
		
		int val = 100;
		val += 20;	//120
		val -= 100;	//20
		val *= 2;	//40
		
		String message = "반갑습니다.";
		message = message + " 지수빈입니다.";
		message = message + " 좋은 하루 보내세요.";
		System.out.println(message);	//반갑습니다. 지수빈입니다. 좋은 하루 보내세요.
		
		int cnt = 0;
		cnt++;	// 증감 연산자(++,--)
		cnt--;
		System.out.println(cnt);

	}

}
