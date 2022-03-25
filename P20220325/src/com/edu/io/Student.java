package com.edu.io;

public class Student {
	// 학생번호(1,2,3), 이름(홍길동), 영어(80), 국어(70).

	private int stuNum;
	private String stuName;
	private int engScore;
	private int korScore;

	// 기본 생성자
	public Student() {

	}

	// 필드
	public Student(int stuNum, String stuName, int engScore, int korScore) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.engScore = engScore;
		this.korScore = korScore;
	}

	// Getter, Setter 생성
	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	// toString() => toString메소드로 재정의. 오버로드
	@Override
	public String toString() {
		return "학생정보 [학생번호: " + stuNum + ", 이름: " + stuName + ", 영어점수: " + engScore + ", 국어점수: "
				+ korScore + "]";
	}

}
