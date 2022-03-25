package com.dev_220316;

public class WhileExample2 {

	public static void main(String[] args) {
		// 1~10 사이의 수 중에서 짝수만 출력.
		
		int i = 1;
		
		while(i <= 10) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}

	}

}
