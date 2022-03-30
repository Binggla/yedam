package com.edu.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// StudentServiceImpl(내부 클래스)의 기능을 대체하는 외부 클래스
// 사용자의 입력, 수정, 삭제 -> 파일에 저장 (메인 기능을 담당하는 execute()에서 사용)
public class StudentServiceFile implements StudentService {

	// filed
	List<Student> stuList = new ArrayList<>();
	File file;
	
	// constructor
	// 기본 생성자에 기존 파일에 저장되어있는 파일 정보를 읽어서 stuList에 먼저 추가해두는 기능을 구현.
	public StudentServiceFile(){
		
		try {
			FileReader fr = new FileReader("studentList.data");
			BufferedReader br = new BufferedReader(fr);
			
			String readBuffer = null;
			while ((readBuffer = br.readLine()) != null) {
				String[] contents = readBuffer.split(","); // , 단위로 분리
				stuList.add(//
						new Student(Integer.parseInt(contents[0]), //
									contents[1], //
									Integer.parseInt(contents[2]), //
									Integer.parseInt(contents[3]) //
									)); 
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	// method

	public Student getStudent(int stuNo) {
		for (int i = 0; i < stuList.size(); i++) {
			if (stuList.get(i).getStuNo() == stuNo) {
				return stuList.get(i);
			}
		}
		return null;
	}

	@Override
	public void insertStudent(Student stu) {
		stuList.add(stu);
	}

	@Override
	public List<Student> studentList() {

		return stuList;
	}

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
		// 작성했던 ArrayList<Student> list 파일 저장
		try {
			FileWriter fw = new FileWriter("studentList.data");
			BufferedWriter bw = new BufferedWriter(fw);

			for (Student stud : stuList) {
				bw.write(stud.getStuNo() + "," + stud.getStuName() + "," + stud.getEngScore() + ","
						+ stud.getKorScore() + "\n");
			}
			bw.close();
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String sameOrNot(int stuNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
