package com.edu.student;

import java.util.ArrayList;
import java.util.List;

public class StudentExample_List {

	public static void main(String[] args) {
		
		List<Student> list = new ArrayList<Student>();
		
		// 인스턴스 생성(기본 생성자)
		Student s1 = new Student();
		// 인스턴스 생성(매개변수가 있는 생성자)
		Student s2 = new Student(101, "지수빈", 100, 100);
		Student s3 = new Student(102, "홍길동", 90, 82);
		Student s4 = new Student(103, "고길순", 95, 78);
		
		list.add(s2);
		list.add(s3);
		list.add(s4);
		
		System.out.println(list.get(0));
		
		// 0번째 인덱스의 인스턴스를 새로운 인스턴스로 변경
		list.set(0, new Student(101, "이지은", 99, 10));
		System.out.println(list.get(0));
		
		// 0번째 인덱스의 국어점수를 100점으로 변경
		list.get(0).setKorScore(100);
		System.out.println(list.get(0));
		
		// 0번째 인덱스의 값 삭제
		list.remove(0);
		System.out.println(list.get(0));	// List 컬렉션은 remove() 이후에 인덱스가 다시 정렬됨.
		

	}

}
