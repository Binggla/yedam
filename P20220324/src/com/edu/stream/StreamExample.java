package com.edu.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Stream;

class Students implements Comparable<Students> {
	String name;
	String gender;
	int score;
	int point;

	public Students(String name, String gender, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	
	
	public Students(String name, String gender, int score, int point) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.point = point;
	}


	@Override
	public String toString() {
		return "Students [name=" + name + ", gender=" + gender + ", score=" + score + ", point=" + point + "]";
	}
	
	@Override
	public int compareTo(Students student) {
		return (this.score + this.point) - (student.score + student.point);
	}

	
	
}

public class StreamExample {

	public static void main(String[] args) {
		
		List<Students> list = new ArrayList<>();
		list.add(new Students("홍길동", "남자", 70));
		list.add(new Students("이소영", "여자", 63));
		list.add(new Students("김영희", "여자", 100));
		list.add(new Students("박철수", "남자", 66));
		
		// 평균 구하기
		int sum = 0, cnt = 0;
		double avg = 0;
		for (Students stu : list) {
			if (stu.gender.equals("남자")) {
				sum += stu.score;
				cnt++;
			}
		}
		
		avg = sum / (double) cnt;
		System.out.println("컬렉션 평균 : " + avg);
		
		
		// Stream 생성
		Stream<Students> stream = list.stream();
		
		// Stream 중간 연산 (메소드 체이닝?)
		
		// 4. 그래서! 최종 연산의 결과 타입이 OptionalDouble.
				// Optional<T> : 지네릭 클래스로 T타입의 객체를 감싸는 래퍼 클래스.
		OptionalDouble od = stream
				.filter(s -> s.gender.equals("남자")) //
					// 1. filter(Predicate<T> predicate) : 조건에 맞지 않는 요소를 제외한다.
				.mapToInt(s -> s.score) //
					// 2. mapToInt(ToIntFunction<T> mapper) : Stream<Students>를 기본형 스트림인 DoubleStream로 맵핑.
				.average(); //
					// 3. average() : DoubleStream에서 사용 가능한 메소드. 평균값 구하기.
		
		avg = od.getAsDouble();
			// getAsDouble() : OptionalDouble 타입의 값을 불러오는 메소드.
		System.out.println("컬렉션 평균 : " + avg);
		
		
		// Stream 최종 연산
		// void forEach(Consumer<? super T> action) : 각 요소에 지정된 작업을 수행한다.
//		stream.forEach(t -> System.out.println("이름 : " + t.name + ", 성별 : " + t.gender + ", 점수 : " + t.score));

	}

}
