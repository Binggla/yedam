package com.friend;

public class Friend extends Person {
	// 이름, 나이, 키, 몸무게 	-> 회사 : 회사이름, 회사업무
	//						-> 학교 : 학교 이름, 전공
	private String phone;
	
	public Friend() {
		super();	// Person();
	}
	
	public Friend(String name, int age, int height, int weight, String phone) {
		super(name, age, height, weight);	// Person(n,a,h,w);
		this.phone = phone;
		
	}
	
	public String getPhone() {
		return phone;
	}
	 
	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	// overriding : 부모 클래스의 메서드를 자식 클래스에서 새롭게 정의하는 것.
	@Override	// annotation : 아래 구문의 규칙을 알려준다.
	public String toString() {
		String str = "이름 : " + super.getName() + "\n" //
				+ "나이 : " + super.getAge() + "\n" //
				+ "연락처 : " + this.getPhone() + "\n";
		return str;
	}
	
	
}
