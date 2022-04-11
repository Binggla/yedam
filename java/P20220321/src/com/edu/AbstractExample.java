package com.edu;

// 추상 클래스 : 추상 메서드를 가지고 있는 클래스
// 자손 클래스를 통해서 실체를 가지는 클래스이며, 추상 클래스는 인스턴스를 생성할 수 없다.
abstract class Animal {
	private String name;

	public Animal() {
		System.out.println("Animal() 생성자 호출");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 추상 메소드 정의.
	// 구현부{} 없이 선언부만 정의한다.
	public abstract void eat();
	public abstract void speak();
}

class Lion extends Animal {

	public Lion() {
		super();
		System.out.println("Lion() 생성자 호출");
	}

	@Override
	public void eat() {
		System.out.println("사자가 먹습니다.");
	}

	@Override
	public void speak() {
		System.out.println("\"나는 사자다.\"");
	}
}

class Tiger extends Animal {

	public Tiger() {
//		super();		// super();를 입력하지 않아도 컴파일러가 자동으로 추가해준다.
		System.out.println("Tiger() 생성자 호출");
	}

	@Override
	public void eat() {
		System.out.println("호랑이가 먹습니다.");
	}

	@Override
	public void speak() {
		System.out.println("\"나는 호랑이다.\"");
	}
}

public class AbstractExample {

	public static void main(String[] args) {

//		Animal animal = new Animal(); // 추상 클래스이기 때문에 인스턴스 생성 불가.

		Animal animal = null;
		animal = new Lion();
		animal.setName("라이언킹");
		animal.eat();
		animal.speak();

		animal = new Tiger();
		animal.setName("수호랑");
		animal.eat();
		animal.speak();

	}

}
