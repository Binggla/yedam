package com.edu;

public class SoccerMember extends Member {
	// 축구반의 코치이름.
	// 락커룸의 이름.(A, B, C, D)

	// 정보출력시 => 코치이름: 홍길동, 락커룸: A

	String team = "축구반";
	String teacherName;
	String locker;

	public SoccerMember(int memberId, String memberName, String phone, String teacherName, String locker) {
		super(memberId, memberName, phone);
		this.teacherName = teacherName;
		this.locker = locker;
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

	public String getLocker() {
		return locker;
	}

	public void setLocker(String locker) {
		this.locker = locker;
	}

	public String toString() {
		String str = "=======================\r\n" //
				+ " 번호\t" + this.getMemberId() + "\r\n" //
				+ " 이름\t" + this.getMemberName() + "\r\n" //
				+ " 휴대폰\t" + this.getPhone() + "\r\n" //
				+ " 코치\t" + this.getTeacherName() + "\r\n" //
				+ " 락커룸\t" + this.getLocker() + "\r\n" //
				+ "=======================\r\n";
		return str;
	}
}
