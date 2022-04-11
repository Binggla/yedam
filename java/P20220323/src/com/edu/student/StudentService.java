package com.edu.student;

import java.util.List;

public interface StudentService {

		public Student getStudent(int stuNo); // 리스트에 있는 지 체크
		
		public void insertStudent(Student stu); // 입력
		public List<Student> studentList(); // 전체 목록
		public void searchStudentNo(int stuNo); // 번호로 찾기
		public List<Student> searchStudentName(String name); // 이름으로 찾기
		public void modifyStudent(Student stu); // 한 건 수정
		public void removeStudent(int stuNo); // 한 건 삭제
		public void saveToFile(); 

}
