package com.edu.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> stuList = new ArrayList<Student>();
	Scanner scan = new Scanner(System.in);

	public void execute() {

		StudentService service = new StudentServiceImpl();
					   service = new StudentServiceOracle();
		// StudentService : 인터페이스
		// StudentServiceImpl, StudentServiceFile : StudentService 인터페이스를 구현한 클래스
			// 왜 다형성을 이용하느냐? StudentService 인터페이스를 구현한 클래스 변경이 필요할 시에
			// 새로운 변수 선언 없이 현재 상태에서 선언 뒷 부분만 변경하면 되기 때문에 사용.
			// 동일한 인터페이스를 새롭게 구현했기 때문에 오류가 나지 않을 것.

		// 메뉴 -> 1.추가 2.리스트 3.조회 4.수정 9.종료
		while (true) {
			printMenu();
			int menu = scan.nextInt();

			if (menu == 1) {
				
				// 학생 정보 입력 : 학생 번호, 이름, 영어점수, 국어점수
				int stuNo = 0;
				while (true) {
					System.out.print("학생 번호 입력 > ");
					stuNo = scan.nextInt();
					
					if (service.sameOrNot(stuNo).equals("same")) {
						System.out.println("중복되는 학생 번호가 있습니다.");
						continue;
					}
					break;
				}

				System.out.print("학생 이름 입력 > ");
				String stuName = scan.next();
				System.out.print("영어 점수 입력 > ");
				int engScore = scan.nextInt();
				System.out.print("국어 점수 입력 > ");
				int korScore = scan.nextInt();
				
				Student newStu = new Student(stuNo, stuName, engScore, korScore);
				service.insertStudent(newStu);
				
			} else if (menu == 2) {

				// service 인스턴스에 저장된 학생 리스트를 List<Student> list에 저장해서 반복문 통해 출력.

				List<Student> searchList = service.studentList();
				
				for (Student s : searchList) {
					System.out.println(s.toString());
				}					

			} else if (menu == 3) {

				int stuNo = 0;
				while (true) {
					System.out.print("조회할 학생 번호 입력 > ");
					stuNo = scan.nextInt();
					
					if (service.sameOrNot(stuNo).equals("not same")) {
						System.out.println("조회되는 학생 번호가 없습니다.");
						continue;
					}
					break;
				}

				service.searchStudentNo(stuNo);

			} else if (menu == 4) {

				System.out.print("조회할 학생 이름 입력 > ");
				String stuName = scan.next();
				List<Student> students = service.searchStudentName(stuName);
				
				for (Student s : students) {
					System.out.println(s);
				}
		

			} else if (menu == 5) {

				int stuNo = 0;
				while (true) {
					System.out.print("수정할 학생 번호 입력 > ");
					stuNo = scan.nextInt();
					
					if (service.sameOrNot(stuNo).equals("not same")) {
						System.out.println("조회되는 학생 번호가 없습니다.");
						continue;
					}
					break;
				}
				System.out.print("영어 점수 수정 > ");
				int engScore = scan.nextInt();
				System.out.print("국어 점수 수정 > ");
				int korScore = scan.nextInt();

				// 수정된 입력 결과로 새로운 인스턴스 생성.
				// stuName은 변경사항이 아니므로 null로 입력.
				Student stu = new Student(stuNo, null, engScore, korScore);

				// modifyStudent() : 동일한 학생 번호를 조회하여
				service.modifyStudent(stu);

			} else if (menu == 6) {
				
				int stuNo = 0;
				while (true) {
					System.out.print("삭제할 학생 번호 입력 > ");
					stuNo = scan.nextInt();
					
					if (service.sameOrNot(stuNo).equals("not same")) {
						System.out.println("조회되는 학생 번호가 없습니다.");
						continue;
					}
					break;
				}


				service.removeStudent(stuNo);

			} else if (menu == 9) {
				service.saveToFile();
				break;
			}
		}

	System.out.println("End of Program");

	}

	// 메뉴 출력
	public void printMenu() {
		String str = "---------------------------------------------------\r\n" //
				+ " 1.추가 2.리스트 3.번호 조회 4.이름 조회 5.수정 6.삭제 9.종료\r\n" //
				+ "---------------------------------------------------\r\n" + "선택 > ";
		System.out.print(str);
	}

}
