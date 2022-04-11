package com.edu.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputExample {
	public static void main(String[] args) {

		// 바이트기반 스트림
		// OutputStream을 이용하여 first.dat 파일 출력. 파일 생성하기.

		try {
			
			OutputStream os = new FileOutputStream("first.dat");
			os.write(10);
			os.write(20);
			os.write(30);
			os.close(); // 스트림을 닫음으로써 사용하고 있던 자원을 반환한다.

		} catch (IOException e) {
			// stream은 반드시 예외처리가 필요하다.
			e.printStackTrace();
		}
		System.out.println("end of prog");
	}

}
