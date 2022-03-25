package com.edu_220317;

import java.util.Scanner;

public class StudentExample {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Student[] students = new Student[5];
		
		while(true) {
			System.out.println("-----------------");
			System.out.println("1.입력 2.리스트 3.종료");
			System.out.println("-----------------");
			System.out.print("선택 > ");
			int menu = scan.nextInt();
			
			if (menu == 1) {
				
				System.out.print("이름을 입력하세요. >> ");
				String sName = scan.next();
				System.out.print("학번을 입력하세요. >> ");
				int sNo = scan.nextInt();
				System.out.print("국어 점수를 입력하세요. >> ");
				int kScore = scan.nextInt();
				System.out.print("수학 점수를 입력하세요. >> ");
				int mScore = scan.nextInt();
				System.out.print("영어 점수를 입력하세요. >> ");
				int eScore = scan.nextInt();
				
				Student stud = new Student(sNo, sName, kScore, mScore, eScore);
				
				for (int i = 0; i < students.length; i++) {
					if (students[i] == null) {
						students[i] = stud;
						break;
					}
				}
				System.out.println("[ 등록 완료 ]");
				
			} else if (menu == 2) {
				
				for (int i = 0; i < students.length; i++) {
					if (students[i] != null) {
						System.out.println(students[i].getStudInfo());
					}
				}
				System.out.println("[ 조회 완료 ]");
	
			} else if (menu == 3) {
				
				System.out.println("프로그램을 종료합니다.");
				break;
				
			} else {
				
				System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
				
			}
		}
		
		System.out.println("<end of program>");
	}

}
