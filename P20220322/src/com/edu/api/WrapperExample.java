package com.edu.api;

import java.util.ArrayList;

public class WrapperExample {

	public static void main(String[] args) {
		// 기본타입(int, long, double, boolean ...)을 참조타입(== Integer, Long, Double, Boolean class ...)으로 변경하는 클래스.
		// 박싱(Boxing) : 기본타입 -> 참조타입
		// 언박싱(Unboxing) : 참조타입 -> 기본타입
		
		
		ArrayList<Integer> ary = new ArrayList<Integer>();
		ary.add(100);	
		ary.add(new Integer(200)); // int type과 Integer Type은 오토박싱이 진행 된다.
		
		ArrayList<Boolean> ary2 = new ArrayList<Boolean>();
		ary2.add(true);
	
		new Integer(100).floatValue();	// Deprecated. 향후 자바에서 제거할 예정.
		ary2.add(new Boolean(1 == 1));
	}

}
