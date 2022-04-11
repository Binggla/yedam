package com.edu;

public class SwimMember extends Member {
	// 수영반의 강사이름.
	// 수영등급(A,B,C,D)

	// 정보출력시 => 강사이름: 홍길동, 등급: A

	String team = "수영반";
	private String teacherName;
	private String grade;

	public SwimMember(int memberId, String memberName, String phone, String teacherName, String grade) {
		super(memberId, memberName, phone);
		this.teacherName = teacherName;
		this.grade = grade;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String toString() {
		String str = "=======================\r\n" //
				+ "번호\t" + this.getMemberId() + "\r\n" //
				+ "이름\t" + this.getMemberName() + "\r\n" //
				+ "휴대폰\t" + this.getPhone() + "\r\n" //
				+ "강사\t" + this.getTeacherName() + "\r\n" //
				+ "등급\t" + this.getGrade() + "\r\n" //
				+ "=======================\r\n";
		return str;
	}

}
