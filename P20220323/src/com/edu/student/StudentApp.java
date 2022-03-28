package com.edu.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

	List<Student> stuList = new ArrayList<Student>();
	Scanner scan = new Scanner(System.in);

	// 내부 클래스 (멤버 클래스)
	class StudentServiceImpl implements StudentService {

		// 리스트 체크
		@Override
		public Student getStudent(int stuNo) {
			for (int i = 0; i < stuList.size(); i++) {
				if (stuList.get(i).getStuNo() == stuNo) {
					return stuList.get(i);
				}
			}
			return null;
		}

		// 1. 학생 추가
		@Override
		public void insertStudent(Student stu) {
			// Student instance를 stuList List에 추가
			stuList.add(stu);
		}

		// 2. 리스트 출력
		@Override
		public List<Student> studentList() {
			return stuList;
		}

		// 3. 학생 번호로 찾기
		@Override
		public void searchStudentNo(int stuNo) {

			// getStudent() : 학생 번호가 리스트에 존재하는지 체크.
			Student searchStu = getStudent(stuNo);

			// 리스트에 없으면 조회되는 학생 번호가 없습니다.
			// 리스트에 있으면 리스트 출력
			if (searchStu == null) {
				System.out.println("조회되는 학생 번호가 없습니다.");
			} else {
				System.out.println(searchStu.toString());
			}
		}

		// 4. 학생 이름으로 찾기 (중복 건이 있을 수 있음)
		@Override
		public List<Student> searchStudentName(String name) {

			List<Student> searchStu = new ArrayList<>();

			while (true) {
				for (int i = 0; i < stuList.size(); i++) {
					if (stuList.get(i).getStuName().equals(name)) {
						searchStu.add(stuList.get(i));
					}
				}
				break;
			}
			return searchStu;
		}

		// 5. 학생 정보 체크 후 수정
		@Override
		public void modifyStudent(Student stu) {

			for (int i = 0; i < stuList.size(); i++) {
				if (stuList.get(i).getStuNo() == stu.getStuNo()) {
					Student changeStu = stuList.get(i);
					changeStu.setEngScore(stu.getEngScore());
					changeStu.setKorScore(stu.getKorScore());
					System.out.println("수정이 완료되었습니다.");
				}
			}
			System.out.println("조회되는 학생 번호가 없습니다.");
		}

		// 6. 삭제
		@Override
		public void removeStudent(int stuNo) {
			Student searchStu = getStudent(stuNo);
			if (searchStu == null) {
				System.out.println("조회되는 학생 번호가 없습니다.");
			} else {
				stuList.remove(searchStu);
				System.out.println("삭제가 완료되었습니다.");
			}

		}

		@Override
		public void saveToFile() {
			
		}

	} // end of StudentServiceImpl

	public void execute() {

		StudentService service = new StudentServiceImpl();
					   service = new StudentServiceFile();
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

				System.out.print("학생 번호 입력 > ");
				int stuNo = scan.nextInt();
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

				System.out.print("조회할 학생 번호 입력 > ");
				int stuNo = scan.nextInt();

				service.searchStudentNo(stuNo);

			} else if (menu == 4) {

				System.out.print("조회할 학생 이름 입력 > ");
				String stuName = scan.next();
				List<Student> searchList = service.searchStudentName(stuName);
				
				if (searchList.size() == 0) {
					System.out.println("조회되는 학생 이름이 없습니다.");
				} else {
					for (Student s : searchList) {
						System.out.println(s.toString());
					}
				}

			} else if (menu == 5) {

				System.out.print("수정할 학생 번호 입력 > ");
				int stuNo = scan.nextInt();
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

				System.out.print("삭제할 학생 번호 입력 > ");
				int stuNo = scan.nextInt();

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
		String str = "-------------------------------------------------\r\n" //
				+ " 1.추가 2.리스트 3.번호 조회 4.이름 조회 5.수정 6.삭제 9.종료\r\n" //
				+ "-------------------------------------------------\r\n" + "선택 > ";
		System.out.print(str);
	}

}
