package com.dev_220318;

import com.edu_220317.Student;			// 다른 패키지의 클래스이기 때문에 import 필요.

public class ObjectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student stu1 = new Student();
		
//		stu1.setStudNo(20142268);		// (default) : 다른 패키지에서 접근 불가.
		stu1.setStudName("지수빈");		// public : 다른 패키지에서도 접근 가능
	}

}
