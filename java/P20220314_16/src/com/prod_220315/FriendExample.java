package com.prod_220315;

class Friend {
	String name;
	String phoneNum;
	String email;
	int height;
	int weight;
}

public class FriendExample {

	public static void main(String[] args) {
		
		Friend f1 = new Friend();
		f1.name = "binggla";
		f1.phoneNum = "010-1234-1234";
		f1.email = "abc@email.com";
		f1.height = 160;
		f1.weight = 50;
		
		Friend f2 = new Friend();
		f2.name = "subin";
		f2.phoneNum = "010-0987-0987";
		f2.email = "qwe@email.com";
		f2.height = 170;
		f2.weight = 60;
		
		Friend f3 = new Friend();
		f3.name = "subb";
		f3.phoneNum = "010-5678-5678";
		f3.email = "asd@email.com";
		f3.height = 155;
		f3.weight = 45;
		
		Friend[] friends = { f1, f2, f3 };
		
		for (int i=0; i < friends.length; i++) {
			if (friends[i].height <= 160) {
				System.out.println("이름 : " + friends[i].name);
				System.out.println("전화번호 : " + friends[i].phoneNum);
				System.out.println("이메일 : " + friends[i].email);
				System.out.println("키 : " + friends[i].height);
				System.out.println("----------------------");
			}
		}
		
		
	}

}
