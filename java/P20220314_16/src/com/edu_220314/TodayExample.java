package com.edu_220314;

import java.util.Scanner;

public class TodayExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String name, phoneNum;
		int age;
		double height, weight, goodWeight;
		
		System.out.println("이름을 입력하세요.");
		name = scn.nextLine();
		System.out.println("연락처를 입력하세요.");
		phoneNum = scn.nextLine();
		System.out.println("나이를 입력하세요.");
		age = scn.nextInt();
		System.out.println("키를 입력하세요.");
		height = scn.nextDouble();
		System.out.println("몸무게를 입력하세요.");
		weight = scn.nextDouble();
		
		goodWeight = (height - 100) * 0.9;
		
		System.out.println("이름 : " + name);
		System.out.println("연락처 : " + phoneNum);
		System.out.println("나이 : " + age);
		System.out.println("키 : " + height);
		System.out.println("몸무게 : " + weight);
		System.out.println("적정 몸무게 : " + goodWeight);
		
		if(weight > goodWeight + 5) {
			System.out.println("과체중입니다.");
		} else if (weight < goodWeight - 5) {
			System.out.println("저체중입니다.");
		} else {
			System.out.println("정상 몸무게입니다.");
		}
		
		scn.close();
	}

}
