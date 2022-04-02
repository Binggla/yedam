package com.blog;

public class User {

	private String userId;
	private String userPw;
	private String userName;
	private String userBirth;
	private String userPhone;

	public User() {
		
	}
	
	public User(String userId) {
		this.userId = userId;
	}
	
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	public User(String userId, String userPw, String userName, String userBirth, String userPhone) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userBirth = userBirth;
		this.userPhone = userPhone;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		
		String str = "\n----------------------\r\n"
				+ " 내 정보\r\n"
				+ "----------------------\r\n"
				+ " 아이디\t" + userId + "\r\n"
				+ " 이름\t" + userName + "\r\n"
				+ " 생년월일\t" + userBirth.substring(0, 10) + "\r\n"
				+ " 휴대폰\t" + userPhone + "\r\n"
				+ "----------------------";
		
		return str;
	}

}
