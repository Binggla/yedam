package com.edu.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputExample {
	public static void main(String[] args) {

		// 바이트기반 스트림 
		// InputStream을 이용하여 first.dat 파일 입력. 파일 불러오기.
		
		try {
			InputStream is = new FileInputStream("first.dat"); 
			int readByte = 0;
			while ((readByte = is.read()) != -1) {
				// read() : 1byte를 읽어온다. 더 이상 읽어올 데이터가 없으면 -1을 반환한다.
				System.out.println(readByte);
			}
			is.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
