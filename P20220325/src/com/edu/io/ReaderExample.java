package com.edu.io;

import java.io.FileReader;
import java.io.IOException;

public class ReaderExample {
	public static void main(String[] args) {
		
		// 문자기반 스트림
		// FileReader를 이용하여 second.txt 파일 입력. 파일 불러오기.
		
		try {
			
			FileReader fr = new FileReader("second.txt");
			int readChar = -1;
			while ((readChar = fr.read()) != -1) {
				System.out.print((char) readChar);
			}
			fr.close();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
