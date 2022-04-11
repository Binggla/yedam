package com.edu.student;

public class Student {
	
	// field
	// 학생번호(1,2,3), 이름(홍길동), 영어(80), 국어(70)
	private int stuNo;
	private String stuName;
	private int engScore;
	private int korScore;

	// constructor
	public Student() {
		
	}
	
	public Student(int stuNo, String stuName, int engScore, int korScore) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.engScore = engScore;
		this.korScore = korScore;
	}

	// method
	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
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
	
	public String toString() {
		String str = "=============\r\n"
				+ "번호\t" + this.getStuNo() + "\r\n"
				+ "이름\t" + this.getStuName() + "\r\n"
				+ "영어 점수\t" + this.getEngScore() + "\r\n"
				+ "국어 점수\t" + this.getKorScore() + "\r\n"
				+ "=============\r\n";
		return str;
	}

}
