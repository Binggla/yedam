package com.edu.collection;

import java.util.ArrayList;

public class ListExample {

	public static void main(String[] args) {

		// String을 담을 수 있는 String 배열 선언
		String[] strings = new String[10];
		for (int i = 0; i < strings.length; i++) {
			if (strings[i] != null) {
				strings[i] = "hello";
				break;
			}
		}

		// 문자열을 담을 수 있는 ArrayList 선언
		ArrayList<String> strAry = new ArrayList<String>();
		
		// add() : ArrayList 내 요소 삽입
		strAry.add("Hello");
		strAry.add("JAVA");

		for (int i = 0; i < strAry.size(); i++) {
			String str = strAry.get(i);
			System.out.println("strAry"+ i + " : " + str);
		}	// Hello Java
		
		// remove(int index) : ArrayList 내 요소 삭제
		strAry.remove(0);
		System.out.println("strAry.remove(0), strAry.get(0) : " + strAry.get(0)); // Hello가 삭제되어 JAVA 출력
		
		// set(int index, changeObject) : 해당 인덱스의 요소 변경
		// get() : 해당 인덱스의 요소 불러오기
		strAry.add("Hello");
		System.out.println("strAry.add(\"Hello\"), strAry.get(1) : " + strAry.get(1));
		strAry.set(1, "Hell"); // 1번 인덱스의 Hello를 Hell로 변경
		System.out.println("strAry.set(1, \"Hell\"), strAry.get(1) : " + strAry.get(1)); // Hell
		
		// clear() : 모든 요소 삭제
		strAry.clear();
		System.out.println("strAry.clear(), strAry.size() : " + strAry.size());

		
		
		ArrayList<Integer> intAry = new ArrayList<Integer>();
		intAry.add(1);
		intAry.add(10);

		for (int i = 0; i < intAry.size(); i++) {
			Integer result = intAry.get(i);
			System.out.println(result);
		}
		


	}

}
