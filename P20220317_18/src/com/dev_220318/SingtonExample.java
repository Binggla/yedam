package com.dev_220318;

public class SingtonExample {

	public static void main(String[] args) {

//		Singleton s1 = new Singleton();			// Singleton class에서 private static으로 선언되었기 때문에
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance(); // 싱글톤은 변수 이름은 다르지만, 하나의 인스턴스만을 참조하는 것이다. 그 인스턴스를 공유하여 사용한다.

		System.out.println(s1 = s2); 			// true - 모두 같은 참조 변수의 주소를 가지고 있다.

	}

}
