package com.edu.lambda.FunctionalInterface;

import java.util.function.IntBinaryOperator;

public class OperatorExample {

	public static void main(String[] args) {
	
		
		// IntBinaryOperator : BiFunction의 자손. BiFuction과 달리 매개변수와 결과의 타입이 같다. (int -> int)
		// Operator Ex_1
	
		IntBinaryOperator intBin = (left, right) -> left + right;
		int result = intBin.applyAsInt(10, 20);
		System.out.println(result);
		
		// Operator Ex_2
		intBin = (num1, num2) -> num1 > num2 ? num1 : num2;
		System.out.println(maxOrMin(intBin));
		
	}
	
	public static int maxOrMin(IntBinaryOperator intBin) {
		int[] intAry = { 85, 47, 92 };
		int result = intAry[0];
		for (int num : intAry) {
			result = intBin.applyAsInt(result, num);
			// 0 > 85 -> 85
			// 85 > 47 -> 85
			// 85 > 92 -> 92
		}
		return result;
	}
}
