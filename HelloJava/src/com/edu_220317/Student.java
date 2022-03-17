package com.edu_220317;

public class Student {

	// field (변수 정의)
	private int studNo;
	private String studName;
	private int korScore;
	private int matScore;
	private int engScore;

	// 생성자 : 인스턴스 생성 시에 필드 값을 초기화할 때 사용. 반환값이 없다.
	public Student() {
		this.studNo = 0;
		this.studName = "NoName";
		this.korScore = -1;
		this.matScore = -1;
		this.engScore = -1;
	}
	
//	public Student(int studNo) {					// 1번 생성자
//		this.studNo = studNo;
//	}
//	
//	public Student(int studNo, String studName) {	// 2번 생성자
//		this.studNo = studNo;
//		this.studName = studName;
//	}
	
	public Student(int studNo, String studName, int korScore, int matScore, int engScore) {
		this.studNo = studNo;
		this.studName = studName;
		this.korScore = korScore;
		this.matScore = matScore;
		this.engScore = engScore;
	}

	// method (기능 정의)
	// 접근제어자 반환타입 메소드명(매개변수(타입 변수명)) { }
									// 접근제어자 private < (default) < protected < public
	int getStudNo() {				// (default) : 다른 패키지인 com.dev.ObjectExample.java에서 접근 불가.
		return this.studNo;
	}

	void setStudNo(int studNo) {
		this.studNo = studNo;
	}

	public String getStudName() {	// public : com.edu_220317.ObjectExample.java에서는 접근 가능.
		return this.studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public int getKorScore() {
		return this.korScore;
	}

	public void setKorScore(int korScore) {	
		this.korScore = korScore;
	}

	public int getMatScore() {
		return this.matScore;
	}

	public void setMatScore(int matScore) {
		this.matScore = matScore;
	}

	public int getEngScore() {
		return this.engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	
	public int getSumScore() {
		int result = 0;
		if(this.korScore != -1 && this.matScore != -1 && engScore != -1) {
			result = this.korScore + this.matScore + this.engScore;
		} else { return -1; }
		return result;
	}

	public double getAvgScore() {
		double result = Math.round((this.getSumScore() / 3.0)*100)/100.0;
		return result;
	}
	
	public void printTestResult() {
		System.out.println(this.studNo + "번 " + this.studName + "의 총 점수 : " + getSumScore());
		System.out.printf(this.studNo + "번 " + this.studName + "의 평균 점수 : %.2f\n", getAvgScore());
	}
	
	public String getStudInfo()	{
		String str = "=============";
		str += "\n학생 이름\t" + this.studName;
		str += "\n학번\t" + this.studNo;
		str += "\n평균 점수\t" + getAvgScore();
		str += "\n=============";
		return str;
	}
	
	public static void callStatic() {				// 3번 static
		System.out.println("정적 메소드 실행");
	}
}
