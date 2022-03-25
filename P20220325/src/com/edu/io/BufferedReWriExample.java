package com.edu.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BufferedReWriExample {

	static Scanner scan = new Scanner(System.in);
	static List<Student> list = new ArrayList<Student>();


	public static void main(String[] args) {

		// 문자기반 보조스트림 
		// BufferedReader, BufferedWriter : 버퍼를 이용해서 입출력의 효율을 높일 수 있도록 해주는 역할.

//		writeStuName();
		readStuName();

		for (Student student : list) {
			System.out.println(student.toString());
		}

		System.out.println("end of program");

	}
	
	public static void writeStuName() {

		try {

			FileWriter fw = new FileWriter("student.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			while (true) {
				System.out.println("학생 정보를 입력하세요. > 101 지수빈 70 80");
				String name = scan.nextLine();
				// next() : 공백이 들어가면 공백 전까지 읽는다.
				// nextLine() : 한 라인 전체를 읽는다.
				if (name.equals("stop")) {
					break;
				}
				bw.write(name + "\n");
			}
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void readStuName() {

		try {

			FileReader fr = new FileReader("student.txt");
			BufferedReader br = new BufferedReader(fr);

			String readStr = null;
			while ((readStr = br.readLine()) != null) {
				// readLine() : 한 라인씩 읽는다. 더이상 읽어들일 라인이 없으면 null을 반환.
				String[] contents = readStr.split(" ");
				// split() : 공백을 기준으로 문장을 자른다. 각각의 정보들을 contents 배열에 저장.

				list.add(new Student(Integer.parseInt(contents[0]), contents[1], Integer.parseInt(contents[2]),
						Integer.parseInt(contents[3])));

//				System.out.println(readStr);
			}
			fr.close();
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
