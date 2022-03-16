package com.prod;

public class ArrayExample {

	public static void main(String[] args) {
		// 1byte = 8bit
		// 처음 1bit는 부호 타입(+, -)을 설정하는 공간으로 사용.

		// byte ( 1byte : -128 ~ 127 )
		byte b1 = 127;
		b1++;
		System.out.println(b1); // -128 // byte 타입은 127까지의 범위를 허용하기 때문에 overflow 발생으로 -128이 된다.
		byte b2 = -128;
		b2--;
		System.out.println(b2); // 127

		// short ( 2byte : -32768 ~ 32767 )
		short s1 = 15864;

		// int ( 4byte : -2147483648 ~ 2147483647 )
		int i1 = 2468145;

		// long ( 8byte : -9223372036854775808 ~ 9223372036854775807 )
		long l1 = 1234568455563L; // long형 타입의 정수임을 알려주기 위해 뒤에 L을 붙인다.

		// ----------------------------------------------------------------------------------------------------------

//		int sum = 0;
//		int score1 = 80;
//		int score2 = 85;
//		int score3 = 91;
//		int score4 = 72;
//		int score5 = 96;
//
//		sum += score1;
//		sum += score2;
//		sum += score3;
//		sum += score4;
//		sum += score5;
//		
//		double avg = sum / (double) 5;

		int[] scores = new int[5];

		scores[0] = 80;
		scores[1] = 85;
		scores[2] = 91;
		scores[3] = 72;
		scores[4] = 96;

		int sum = 0;
		for (int i = 0; i < 5; i++) {
			System.out.println((i+1) + "번 : " + scores[i] + "점");
			sum += scores[i];
		}
		double avg = sum / (double) 5;
		System.out.println("평균 점수 : " + avg);

	}

}
