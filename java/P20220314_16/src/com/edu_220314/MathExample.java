package com.edu_220314;

import java.util.Scanner;

public class MathExample {

	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		
		int num, num2, hap, cha, gob, mok, na;
		
		System.out.println("첫 번째 정수를 입력하세요.");
		num = scn.nextInt();
		System.out.println("두 번째 정수를 입력하세요.");
		num2 = scn.nextInt();
		
		hap = num + num2;
		cha = num - num2;
		gob = num * num2;
		mok = num / num2;
		na = num % num2;
		
		System.out.println("두 수의 합 : " + hap);
		System.out.println("두 수의 차 : " + cha);
		System.out.println("두 수의 곱 : " + gob);
		System.out.println("두 번째 수로 첫 번째 수를 나눴을 때 몫 : " + mok);
		System.out.println("두 번째 수로 첫 번째 수를 나눴을 때 나머지 : " + na);
		
		scn.close();
	}

}
