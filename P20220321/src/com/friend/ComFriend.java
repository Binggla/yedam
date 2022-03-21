package com.friend;

public class ComFriend extends Friend {

	// field
	private String company;
	private String job;

	// Constructor
	public ComFriend() {
		super(); // super() : 부모 클래스가 가지고 있는 기본 생성자를 호출.
	}

	public ComFriend(String name, int age, int height, int weight, String phone, String company, String job) {
		super(name, age, height, weight, phone);
		this.company = company;
		this.job = job;

	}

	// Method
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	// overriding : 부모 클래스의 메서드를 자식 클래스에서 새롭게 정의하는 것.
	@Override // annotation : 아래 구문의 규칙을 알려준다.
	public String toString() {
		String str = "이름 : " + super.getName() + "\n" //
				+ "나이 : " + super.getAge() + "\n" //
				+ "연락처 : " + super.getPhone() + "\n" //
				+ "< 추가 정보 >\n" //
				+ "직장 : " + this.getCompany() + "(" + this.getJob() + ")\n";
		return str;
	}

}
