package com.dev_220318;

public class DimensionArray {

	public static void main(String[] args) {

		int[][] intRectAry = new int[5][5];
		int cntNum = 1;
		
		for (int i=0; i<5; i++) {
			for (int j=0; j<5; j++) {
				intRectAry[i][j] = cntNum++;
			}
		}
		
		for (int i=4; i>=0; i--) {
			for (int j=4; j>=0; j--) {
//				System.out.println("[" + i + "][" + j + "]" + "=>" + intRectAry[i][j]);
				System.out.printf("%-3d", intRectAry[i][j]);
			}
			System.out.println();
		}
		
		
		
		int[] intAry = { 20, 38, 45 };
		System.out.println(intAry[0]);

		int[][] intDimAry = { { 23, 24 }, { 12, 32, 45 }, { 37, 39 } };
		int [] anotherAry = intDimAry[0]; 
		System.out.println(anotherAry[0] == intDimAry[0][0]);
		
		System.out.println(intDimAry[0][1]);
		intDimAry[1][1] = 33;
		System.out.println(intDimAry[1][1]);
	}

}
