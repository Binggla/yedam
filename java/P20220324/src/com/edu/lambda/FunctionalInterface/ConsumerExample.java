package com.edu.lambda.FunctionalInterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		// java.util.function 패키지
		// 매개변수와 반환값의 유무에 따라 4개의 함수형 인터페이스가 정의되어있음.
		// Supplier<T> : 매개변수 X, 반환값 O
		// Consumer<T> : 매개변수 O, 반환값 X
		// Function<T, R> : 매개변수 O, 반환값 O
		// Predicate<T> : 조건식을 표현하는 데에 사용. 매개변수는 1개이고 반환 타입은 Boolean.
		
		
		// 1. Consumer<T> : 매개변수가 1개인 Consumer
		Consumer<String> con = (t) -> System.out.println(t + "를 출력합니다.");
		con.accept("메세지를");
		
		// 2. BiConsuber<T, U> : 매개변수가 2개인 Consumer
		BiConsumer<Integer, Integer> biCon = (t, u) -> System.out.println(t + "+" + u + "=" + (t+u));
		biCon.accept(5, 7);
		
		// 
		
	}


}
