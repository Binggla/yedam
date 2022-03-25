package com.edu.api;

import java.util.*;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1 = new Member("blue", "홍길동");
		Member obj2 = new Member("blue", "홍길동");

		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1과 obj2는 동등합니다.");
		} else {
			System.out.println("obj1과 obj2는 동등하지 않습니다.");
		}
		
		// 배열은 크기가 한 번 정해지면 수정할 수 없음. 더 큰 크기의 배열에 복사하는 과정을 거쳐야 함.
		// 그래서 컬렉션(ArrayList, HaseSet, HashMap)을 사용 한다. 컬렉션은 여러 개의 값을 저장할 수 있는 자료 구조.
		
		Member[] memberAry = new Member[5];	// Member 클래스의 인스턴스를 최대 5개 저장 가능.
		ArrayList<Member> memList = new ArrayList<Member>();
		memList.add(new Member("user1", "홍길동"));
		memList.add(new Member("user1", "홍길동"));
		
		for (int i = 0; i < memList.size(); i++) {
			System.out.println(memList.get(i));
		}
		
		// HashSet은 ArrayList와 달리 중복값을 저장하지 않음.
		HashSet<Member> memSet = new HashSet<Member>();
		memSet.add(new Member("user2", "홍길순")); // hashCode(), equals() 메소드가 관여
		memSet.add(new Member("user2", "홍길동"));
		
		System.out.println(memSet.size()); // 2
		
//		for (int i = 0; i < memList.size(); i++) {
//			System.out.println(memㄴㄷㅅ.get(i));
//		}

	}

}
