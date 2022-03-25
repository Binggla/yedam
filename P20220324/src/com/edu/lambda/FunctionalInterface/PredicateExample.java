package com.edu.lambda.FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Students {
	String name;
	String gender;
	int score;

	public Students(String name, String gender, int score) {
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

}

public class PredicateExample {
	

	public static void main(String[] args) {
		// Predicate<T> : 조건식을 표현하는 데에 사용. 매개변수는 1개이고 반환 타입은 Boolean.
		
		Predicate<Students> pridic = (Students t) -> { return t.gender.equals("남자"); };
		
		double avg = avg(pridic);
		System.out.println("남학생의 평균 : " + avg);
		
		pridic = t -> t.gender.equals("여자");
		
		avg = avg(pridic);
		System.out.println("여학생의 평균 : " + avg);


	}

	public static double avg(Predicate<Students> pred) {
		List<Students> list = new ArrayList<>();
		list.add(new Students("홍길동", "남자", 70));
		list.add(new Students("이소영", "여자", 63));
		list.add(new Students("김영희", "여자", 100));
		list.add(new Students("박철수", "남자", 66));

		int cnt = 0;
		int sum = 0;
		double avg = 0;

		for (Students stu : list) {
			if (pred.test(stu)) {
				cnt++;
				sum += stu.score;
			}
		}
		avg = sum / cnt;
		return avg;
	}

}
