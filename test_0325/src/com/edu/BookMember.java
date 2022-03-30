package com.edu;

public class BookMember extends Member {
	// 도서반의 반장이름.
	// 도서반의 강의실정보.(지혜실, 지식실, 모험실)

	// 정보출력시 => 반장이름: 홍길동, 강의실: 모험실

	String team = "도서반";
	String leaderName;
	String className;

	public BookMember(int memberId, String memberName, String phone, String leaderName, String className) {
		super(memberId, memberName, phone);
		this.leaderName = leaderName;
		this.className = className;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public BookMember(int memberId, String memberName, String phone) {
		super(memberId, memberName, phone);
	}

	public String getLeaderName() {
		return leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String toString() {
		String str = "=======================\r\n" //
				+ " 번호\t" + this.getMemberId() + "\r\n" //
				+ " 이름\t" + this.getMemberName() + "\r\n" //
				+ " 휴대폰\t" + this.getPhone() + "\r\n" //
				+ " 반장\t" + this.getLeaderName() + "\r\n" //
				+ " 강의실\t" + this.getClassName() + "\r\n" //
				+ "=======================\r\n";
		return str;
	}
}
