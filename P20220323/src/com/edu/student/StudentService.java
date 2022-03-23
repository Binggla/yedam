package com.edu.student;

import java.util.List;

public interface StudentService {

		public void insertStudent(Student stu); // 입력
		public Student getStudent(int stuNo); // 한 건 조회
		public List<Student> studentList(); // 전체 목록
		public void modifyStudent(Student stu); // 한 건 수정

}
