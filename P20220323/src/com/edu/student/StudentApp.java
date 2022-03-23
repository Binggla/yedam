package com.edu.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> stuList = new ArrayList<Student>();
	Scanner scan = new Scanner(System.in);

	// 내부 클래스 (멤버 클래스)
	class StudentServiceImpl implements StudentService {

		// 1. 추가
		@Override
		public void insertStudent(Student stu) {
			stuList.add(stu); // Student instance를 stuList List에 추가
		}

		// 2. 리스트
		@Override
		public List<Student> studentList() {
			return stuList;
		}

		// 3. 조회
		@Override
		public Student getStudent(int stuNo) {
			for (int i = 0; i < stuList.size(); i++) {
				if (stuList.get(i).getStuNo() == stuNo) {
					return stuList.get(i);
				}
			}
			return null;
		}

		// 4. 수정
		@Override
		public void modifyStudent(Student stu) {
			for (int i = 0; i < stuList.size(); i++) {
				if (stuList.get(i).getStuNo() == stu.getStuNo()) {
					Student changeStu = stuList.get(i);
					changeStu.setEngScore(stu.getEngScore());
					changeStu.setKorScore(stu.getKorScore());
				}
			}
		}

	} // end of StudentServiceImpl

	public void execute() {
		// 메뉴 -> 1.추가 2.리스트 3.조회 4.수정 9.종료
		
		while (true) {
			printMenu();
			int menu = scan.nextInt();

			if (menu == 1) {
	
			} else if (menu == 2) {

			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 9) {
				break;
			}
		}

		System.out.println("End of program");
	}

	public void printMenu() {
		String str = "-------------------------------------\r\n" //
				+ " 1. 추가 2. 리스트 3. 조회 4. 수정 9. 종료\r\n" //
				+ "-------------------------------------\r\n" + "선택 > ";
		System.out.print(str);
	}
}
