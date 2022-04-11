package com.edu.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedInOutExample {
	public static void main(String[] args) throws FileNotFoundException {
		
		// 바이트기반 보조스트림
		// BufferedInputStream, BufferedOutputStream : 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조 스트림.
		//											   한 바이트씩 입출력하는 것보다 버퍼(바이트배열)을 이용하여 한 번에 여러 바이트를 입출력하는 것이 빠르다.
		
		FileInputStream fis = new FileInputStream("C:/temp/puppy.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis); // 보조스트림 Buffered~ 를 통해 성능 향상
		FileOutputStream fos = new FileOutputStream("C:/temp/copy3.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		// 입출력 스트림을 try () 구문 안에 선언해주면 close()를 사용하지 않아도 된다.
		// 1. 모든 문장을 구문 안에 넣는 방법 2. 변수 이름을 넣어주는 방법
		try (fis; bis; fos; bos) {

			int readByte = -1;
			while ((readByte = bis.read()) != -1) {
				bos.write(readByte);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("end of prog");
	}
}
