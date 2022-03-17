package com.edu_220317;

public class BankAccount {
	
	// 필드 (계좌 정보, 예금주, 예금액)
	private String accNo;
	private String accName;
	private int accMoney;

	public String getAccNo() {
		return accNo;
	}

	// 생성자(Constructor)
	public BankAccount(String accNo, String accName, int money) {
		this.accNo = accNo;
		this.accName = accName;
		this.accMoney = money;
	}
	
	// 메소드(Method)
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
