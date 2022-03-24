package com.prod_220315;

class User {
	private String userId;
	private String userGrade;
	private String userPhone;
	private int userPoint;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public void getUserInfo() {
		System.out.println("User ID : " + this.userId);
		System.out.println("Grade : " + this.userGrade);
		System.out.println("Phone Number : " + this.userPhone);
		System.out.println("Point : " + this.userPoint);
	}
}

public class UserExample {

	public static void main(String[] args) {

		User user1 = new User();
		User user2 = new User();
		User user3 = new User();

		user1.setUserId("xoxwowdod");
		user1.setUserGrade("VVIP");
		user1.setUserPhone("010-1234-1234");
		user1.setUserPoint(1500);

		user2.setUserId("wlqls12");
		user2.setUserGrade("VVIP");
		user2.setUserPhone("010-5678-5678");
		user2.setUserPoint(620);

		user3.setUserId("jeeesubb");
		user3.setUserGrade("Gold");
		user3.setUserPhone("010-0987-0987");
		user3.setUserPoint(2780);

		User[] users = { user1, user2, user3 };

		for (int i = 0; i < users.length; i++) {
			if (users[i].getUserGrade().equals("VVIP") && users[i].getUserPoint() > 1000) {
				users[i].getUserInfo();
			}		
		}
//		for (int i = 0; i < users.length; i++) {
//			if (users[i].getUserPoint() > 1000) {
//				users[i].getUserInfo();
//			}		
//		}


	}

}
