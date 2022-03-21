package com.friend;

public class InheritExample {
	// 학생, 직장인, 친구 
	// 학교, 학년
	// 직장명, 직급
	// 출신지역
	
	public static void main(String[] args) {
		
		Student std1 = new Student();
		
		std1.setName("학생");
		std1.setAge(18);
		std1.setSchool("예담고등학교");
		
		Worker wrk1 = new Worker();
		
		wrk1.setName("직장인");
		wrk1.setAge(35);
		wrk1.setCompany("(주)예담");
		wrk1.setJob("개발 팀장");

		// 부모클래스의 창조변수에 자식클래스의 참조변수를 넣을 수 있다. 자동형변환 가능.
		Person prs1 = new Person();
		prs1 = (Person) std1;
		prs1 = wrk1;
		
	}

}
