package com.edu.generic;

public class BoxExample {

	public static void main(String[] args) {

//		Box box = new Box();
//		box.setObj("Hello");
//		String result = (String) box.getObj();
//			// Object 타입으로 return되는 메소드이기 때문에 String으로 casting 처리 (String -> String)
//		System.out.println(result);
//
//		Integer result1 = (Integer) box.getObj(); // (String -> Integer)
//			// java.lang.ClassCastException
//			// 컴파일 시점에서 오류를 나타내주었으면 좋겠음.
		
		Box<String> stringBox = new Box<String>();
		stringBox.setObj("Hello");
		System.out.println(stringBox.getObj());
		
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.setObj(10);
		System.out.println(integerBox.getObj());
		
		

	}

}
