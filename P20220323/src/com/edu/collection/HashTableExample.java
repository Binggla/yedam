package com.edu.collection;

import java.util.*;

public class HashTableExample {

	public static void main(String[] args) {
		// 오른쪽 <> 파라미터 생략 가능
		Map<String, String> map = new Hashtable<>();
		
		map.put("spring", "12");
		map.put("summer", "123");
		map.put("fall", "1234");
		map.put("winter", "12345");
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.println("아이디와 비밀번호를 입력하세요.");
			System.out.print("아이디 : ");
			String id = scan.nextLine();
			System.out.print("비밀번호 : ");
			String password = scan.nextLine();
			System.out.println();
			
			// containsKey(Object key) : Hashtable에 지정된 key가 포함되어있는지 알려준다. (포함되어 있으면 true)
			// containsValue(Object value) : Hashtable에 지정된 key가 포함되어있는지 알려준다. (포함되어 있으면 true)
			if(map.containsKey(id)) {
				if(map.get(id).equals(password)) {
					System.out.println("로그인되었습니다.");
					break;
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			} else {
				System.out.println("입력하신 아이디가 존재하지 않습니다.");
			}
			
		}

	}

}
