package com.friend;

public class FreindListApp {

	public static void main(String[] args) {

		Friend[] friends = new Friend[10];
		
		// Friend instance.
		Friend f1 = new Friend();
		f1.setName("김영희");
		f1.setAge(28);
		f1.setHeight(160);
		f1.setWeight(50);
		f1.setPhone("010-1234-1234");

		// UnivFriend instance.
		UnivFriend f2 = new UnivFriend("박철수", 29, 180, 70, "010-2354-2354");
		f2.setUniversity("대구대학교");
		f2.setMajor("컴퓨터공학과");

		// ComFriend instance.
		ComFriend f3 = new ComFriend("고길동", 34, 170, 65, "010-7894-7894", "네이버", "지도 앱 개발 연구원");
		UnivFriend f4 = new UnivFriend("박철수", 29, 180, 70, "010-2354-2354");
		ComFriend f5 = new ComFriend("고길동", 34, 170, 65, "010-7894-7894", "네이버", "지도 앱 개발 연구원");
		UnivFriend f6 = new UnivFriend("박철수", 29, 180, 70, "010-2354-2354");
		UnivFriend f7 = new UnivFriend("박철수", 29, 180, 70, "010-2354-2354");
		ComFriend f8 = new ComFriend("고길동", 34, 170, 65, "010-7894-7894", "네이버", "지도 앱 개발 연구원");

		// 배열에 인스턴스 등록.
		// 상속 관계이기 때문에 타입이 달라도 배열에 넣을 수 있음.
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[3] = f4;
		friends[4] = f5;
		friends[5] = f6;
		friends[6] = f7;
		friends[7] = f8;

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) // && friends[i] instanceof ComFriend) {
				{ System.out.println(friends[i]);
			}
		}


		// 형변환 ---------------------------------------------------------------------
		
		
		UnivFriend uFr = new UnivFriend();
		Friend fr = uFr;						// 부모 클래스로의 형변환은 자동형변환.
		UnivFriend uF2 = (UnivFriend) fr;		// 자식 클래스로의 형변환은 강제형변환.

//		UnivFriend f2 = new Friend();			// Error : 부모가 자손보다 더 적은 멤버를 가지고 있기 때문에 없는 멤버를 호출할 가능성이 있기 때문에 에러 발생

		if (fr instanceof UnivFriend) { 		// 부모 -> 자식
			System.out.println("변환 가능");
			UnivFriend uf3 = (UnivFriend) fr;
		}

		if (uFr instanceof Friend) {			// 자식 -> 부모
			System.out.println("변환 가능");
			Friend fr2 = uFr;
		}

	}
}
