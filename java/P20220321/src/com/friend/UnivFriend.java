package com.friend;

public class UnivFriend extends Friend {
	
	// field
	private String university;
	private String major;
	
	// Constructor
	
	public UnivFriend() {
		super();	//Friend();
	}
	
	public UnivFriend(String name, int age, int height, int weight, String phone) {
		super(name, age, height, weight, phone);	// Friend(n,a,h,w,p);

	}
	
	public UnivFriend(String name, int age, int height, int weight, String phone, String university, String major) {
		super(name, age, height, weight, phone);	// Friend(n,a,h,w,p);
		this.university = university;
		this.major = major;
	}

	
	// Method
	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// overriding : 부모 클래스의 메서드를 자식 클래스에서 새롭게 정의하는 것.
	@Override	// annotation : 아래 구문의 규칙을 알려준다.
	public String toString() {
		String str = "이름 : " + super.getName() + "\n" //
				+ "나이 : " + super.getAge() + "\n" //
				+ "연락처 : " + super.getPhone() + "\n" //
				+ "< 추가 정보 >\n" //
				+ "학교 : " + this.getUniversity() + "(" + this.getMajor() + ")\n";
		return str;
	}

	
}
