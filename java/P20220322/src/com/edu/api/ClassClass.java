package com.edu.api;

import java.lang.reflect.Method;

public class ClassClass {

	public static void main(String[] args) {
		// Stirng, System, Member -> 관리하는 class
		
		// Class class - String
		Class cls = String.class;                  
		try {
			cls = Class.forName("java.lang.String");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());

		Method[] methods = cls.getMethods();

//		for (Method met : methods) {
//			System.out.println(met.getName());
//		}
		
		// Class class - Member
		cls = Member.class;
		String path = cls.getResource("ClassExample.class").getPath();
		
		System.out.println(path);
		
	}

}
