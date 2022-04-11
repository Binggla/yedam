package com.edu_220317;

import java.util.Scanner;

// Class(도면, 틀) -> Instance 생성

public class ObjectExample {

	public static void main(String[] args) {
		
		int num1 = 10;
		double num2 = 12.34;
		
		// int type의 범위가 double type 범위보다 작기 때문에 자동형변환(Promotion)이 적용된다.
		double num3 = 10; 		// == (double num3 = (double) 10;)
		 
		// 같은 이유로  double type은 int type으로 자동형변환되지 않기 때문에 강제형변환(Casting) 해주어야한다.			
		// 23.4 에서 소수점 아래 자리가 다 날아감.
		int num4 = (int) 23.4;  

		String str1 = "Hello";	// heap(인스턴스) 생성.
		
		// 클래스 생성 ---------------------------------------------------------------------
		
		Car car1 = new Car();	// 초기화(인스턴스 생성)
		car1.setModel("Sonata");
		car1.setPrice(20000000);
		
		Student stud1 = new Student();
		stud1.setStudNo(100);
		stud1.setStudName("지수빈");
		stud1.setKorScore(100);
		stud1.setMatScore(30);
		stud1.setEngScore(85);
	
//		System.out.println(stud1.getStudName());
//		stud1.printTestResult();
		
		// 생성자 -------------------------------------------------------------------------
		
//		Student stud2 = new Student(200);			// Student class 1번
//		Student stud3 = new Student(300, "홍길동");	// Student class 2번
	
		Scanner scan = new Scanner(System.in);
		
		Student stud4 = new Student(400, "김영희", 100, 80, 65);
		Student stud5 = new Student(500, "박철수", 60, 30, 25);
		Student stud6 = new Student(600, "이지영", 60, 70, 58);
		
		Student[] students = { stud1, stud4, stud5, stud6 };
	
		
		while (true) {
			System.out.print("조회할 학생의 이름을 입력하세요. (종료:Q) > ");
			String searchName = scan.nextLine();

			if (searchName.equals("Q") || searchName.equals("q")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
			for (int i = 0; i < students.length; i++) {
				if(searchName.equals(students[i].getStudName())) {
					System.out.println(students[i].getStudInfo());
					break;
				}
				System.out.println("조회할 대상이 없습니다. 다시 입력하세요.");
				break;
			}
		}
	
		// static ----------------------------------------------------------------------
		
		Student.callStatic();	// 정적 메소드 실행.
								// Student class 3번 
	
		// static method는 인스턴스 생성(=초기화) 없이 클래스 이름을 통해 사용 가능.
		// 특히 main()는 class 실행 시에 바로 실행되는 메소드.
		
		System.out.println(Student.schoolName);	// 예담.
		Student.schoolWhere = "대구"; 			// 대구.
		// static 변수는 인스턴스 생성 없이 클래스 이름을 통해 사용 가능하다.
		
		
	
	}

}
