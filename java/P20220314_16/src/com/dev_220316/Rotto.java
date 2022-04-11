package com.dev_220316;

public class Rotto {

	public static void main(String[] args) {
		
		int[] rotto = new int[7];
		
		for (int i=0; i<rotto.length; i++) {
			rotto[i] = (int) (Math.random() * 45) + 1;
			for (int j=0; j<i; j++) {
				if (rotto[i] == rotto[j]) {
					i--;
				}
			}
		}
		
		for (int i : rotto) {
			System.out.println(i);
		}

	}

}
