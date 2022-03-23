package com.edu.collection;

import java.util.*;

public class MapExample {

	public static void main(String[] args) {
		// Map : {key, value} 쌍으로 저장되는 컬렉션
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		// put() : Map map에 요소 삽입
		map.put("전민욱", 80);
		map.put("김형민", 90);
		map.put("김영민", 85);
		map.put("김영민", 100); 	// 동일한 key값의 요소를 삽입하면 후에 삽입한 요소로 대체.
		
		// get(key) : key 값을 입력하면 value 값 반환.
		System.out.println(map.get("김영민")); 	// 100
		
		// keySet() : 저장된 요소들의 모든 키 값의 Set를 반환.
		Set<String> keySet = map.keySet();
		System.out.println(keySet);		// [김영민, 전민욱, 김형민]
		
		
		// 1)
		// Set<String> keySet의 값을 반복자로 불러오기.
		// 반복문을 통해 value 값도 함께 불러오기.
		Iterator<String> iter = keySet.iterator();
		
		while(iter.hasNext()) {
			String key = iter.next();
			Integer val = map.get(key);
			System.out.printf("key : %-5svalue : %-5d\n", key, val);
		}
		
		// 2)
		// 향상된 for문을 이용
		for (String key : keySet) {
			Integer val = map.get(key);
			System.out.printf("key : %-5svalue : %-5d\n", key, val);
		}
	}

}
