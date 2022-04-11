package com.prod_220315;

import java.util.Scanner;

public class ArrayExample3 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String[] names = new String[5];
		names[0] = "홍길동";
		names[1] = "지수빈";
		names[2] = "예담";
		names[3] = "배고파";
//		names[4] = "ㄹㄹㄹ";		// String 배열의 빈 값은 null로 채워진다.
		
		System.out.print("찾는 이름을 입력하세요. > ");
		String searchName = scan.nextLine();
		
		for (int i = 0; i < names.length; i++) {		// null 값을 제외하여 출력
			if (names[i] != null) {
				System.out.println("이름: " + names[i]);
			}
		}
		
		for (int i = 0; i < names.length; i++) {		// 입력값과 동일한 값의 위치를 출력
			if (names[i] != null && searchName.equals(names[i])) {
				System.out.println(searchName + "은(는) " + (i+1) + "번째 위치입니다.");
			}
		}
		
		scan.close();

	}

}
