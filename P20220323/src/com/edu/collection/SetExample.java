package com.edu.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample {

	public static void main(String[] args) {
		
		// String을 담는 Set set을 선언
		Set<String> set = new HashSet<String>();
		
		set.add("Hello");
		set.add("World");
		set.add("Good");
		set.add("Good");
		
		System.out.println("set.size() : " + set.size()); // 3 // Set은 중복값을 허용하지 않는다.
		
		set.remove(1);	// Set은 순서가 없기 때문에 인덱스 번호로는 삭제 불가.
		set.remove("World");
		
		System.out.println("set.size() : " + set.size()); // 2
		
		
		// 반복자(iterator) : 요소를 하나씩 끄집어낸다.
		Iterator<String> iter = set.iterator();
			
			// hasNext() : 읽어 올 요소가 남아있는지 확인. 있으면 true, 없으면 false를 반환
			// next() : 다음 요소를 읽음. next() 호출 전에 hasNext()를 호출해서 읽어 올 요소가 있는지 먼저 확인하는 것이 안전.
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
