package com.edu.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamExample2 {

	public static void main(String[] args) {
		
		List<Students> list = new ArrayList<>();
		list.add(new Students("홍길동", "남자", 85, 305));
		list.add(new Students("이소영", "여자", 63, 240));
		list.add(new Students("김영희", "여자", 100, 500));
		list.add(new Students("박철수", "남자", 66, 100)); 
		
		list //
		.stream()
		.filter(student -> student.score + student.point >= 180)
		.sorted() 
		.forEach(student -> System.out.println(student));
		
		System.out.println();
		
		list // 컬렉션으로부터
		.stream() // 스트림 생성.
		.filter(student -> student.score >= 80) // 중간 연산. 80점 이상인 대상을 필터링.
		.filter(student -> student.gender.equals("여자")) // 여자인 대상을 필터링.
		.forEach(student -> System.out.println(student)); // 최종 연산. 필터링된 대상을 출력.

	}

}
