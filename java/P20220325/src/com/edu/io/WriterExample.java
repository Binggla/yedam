package com.edu.io;

import java.io.FileWriter;
import java.io.IOException;

public class WriterExample {
	public static void main(String[] args) {
		
		// 문자기반 스트림
		// FileWriter를 이용하여 second.txt 파일 출력. 파일 생성하기.
		
		try {
			
			FileWriter fw = new FileWriter("second.txt");
			fw.write("Hello\n");
			fw.write("world\n");
			fw.close(); // 스트림을 닫음으로써 사용하고 있던 자원을 반환한다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog");
	}

}
