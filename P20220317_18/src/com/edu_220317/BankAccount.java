package com.edu_220317;

public class BankAccount {
	
	// 필드 (계좌 정보, 예금주, 예금액)
	private String accNo;
	private String accName;
	private int accMoney;
	
	public static String bankName;	// static 변수 선언
	static {
		bankName = "예담";
	}


	// 생성자(Constructor)
	
	public BankAccount() {	// 기본 생성자
		System.out.println("기본 생성자 호출!");
	}
	
	public BankAccount(String accNo, String accName, int money) {
		this.accNo = accNo;
		this.accName = accName;
		this.accMoney = money;
	}
	
	public BankAccount(String accNo) {	// 오버로딩(overloading) : 동일한 이름의 메소드를 선언. 매개변수는 달라야한다.
		this(accNo, null, 0);			// this() : 다른 생성자를 호출하여 중복 줄이기.
	}
	
	// 메소드(Method)
	
	public String getAccNo() {
		return accNo;
	}
	
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getMoney() {
		return accMoney;
	}

	public void setMoney(int accMoney) {
		this.accMoney = accMoney;
	}
	
	@Override
	public String toString() {
		return "BankAccount [accNo=" + accNo + ", accName=" + accName + ", accMoney=" + accMoney + "]";
	}

}
