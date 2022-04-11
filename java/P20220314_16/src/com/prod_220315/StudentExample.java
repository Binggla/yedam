package com.prod_220315;

public class StudentExample {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.studentNo = "20142268";
		s1.studentName = "지수빈";
		s1.editScore = "A";
		s1.illustScore = "B+";
		
		s1.task("타이포 작업");
		s1.task("일러스트 작업");
		s1.eat("저녁");
		s1.eat("술");
		
		String edit = s1.getEditScore();
		String illust = s1.getIllustScore();
		System.out.println("타이포그래피 : " + edit + ", 일러스트레이트 : " + illust);

	}

}
