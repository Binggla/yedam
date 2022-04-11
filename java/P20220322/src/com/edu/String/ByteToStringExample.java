package com.edu.String;

import java.io.IOException;

public class ByteToStringExample {

	public static void main(String[] args) throws IOException {
		
		// String 생성자
		// String str = new String(byte[] bytes); 배열 전체를 String 객체로 생성
		// String str = new String(byte[] bytes, int offset, int length); 배열의 offset 인덱스 위치부터 length만큼 String 객체로 생성
		
		byte[] bytes = { 72, 101, 108, 108, 111, 32, 74, 97, 118, 97 };
		
		String str1 = new String(bytes);
		System.out.println(str1);	// Hello Java
		
		String str2 = new String(bytes, 6, 4);
		System.out.println(str2);	// Java
		
		// --------------------------------------------------------------------
		
		byte[] bytes2 = new byte[100];
		
		System.out.print("입력 : ");
		int readByteNo = System.in.read(bytes2); // 입력된 문자열에 \r\n까지 추가로 저장됨.
		
		String str = new String(bytes, 0, readByteNo-2); // -2를 뺀 이유는 \r\n은 문자열에 포함시킬 필요가 없기 때문에.
		System.out.println(str);
	}

}
