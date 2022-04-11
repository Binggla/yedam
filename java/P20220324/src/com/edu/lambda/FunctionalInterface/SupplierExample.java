package com.edu.lambda.FunctionalInterface;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		// Supplier<T> : 매개변수 X, 반환값 O
		
		// IntSupplier
		IntSupplier intSup = () -> (int) (Math.random()*10);
		
		int result = intSup.getAsInt();
		System.out.println("결과 값은 " + result);
		
	}
}
