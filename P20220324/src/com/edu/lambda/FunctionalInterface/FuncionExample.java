package com.edu.lambda.FunctionalInterface;

import java.util.function.ToIntFunction;

public class FuncionExample {

	public static void main(String[] args) {
		// Function<T, R> : 매개변수 O, 반환값 O. 매핑 작업 시 사용. (Student -> int)
		
		ToIntFunction<Student> func = stu -> stu.getEngScore() + stu.getKorScore();
		
		int result = func.applyAsInt(new Student(101, "Hong", 80, 90));
		System.out.println("결과값 : " + result);
			

	}

}
