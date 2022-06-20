package com.yedam.myserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.yedam.myserver.emp.vo.Employee;

public class LamdaTest {
	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
		
		list.add(Employee.builder().email("a@a.c").salary(1000).build());
		list.add(Employee.builder().email("z@a.c").salary(200).build());
		list.add(Employee.builder().email("c@a.c").salary(2000).build());
		list.add(Employee.builder().email("k@a.c").salary(500).build());
		
		// 객체 정렬
		// (1) 따로 클래스를 생성하여 정렬
		Collections.sort(list, new EmpComp());
		
		// (2) 익명 클래스(implements Comparator<Employee>) 생성하여 정렬
		// 익명 클래스 : 클래스 선언과 생성을 동시에. 1번만 사용 가능.
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getSalary() - o2.getSalary();
			}
		
		});
		
		// (3) 인터페이스를 상속받은 익명 클래스의 람다식 표현 
		//      -> 부모 인터페이스의 메서드가 하나인 경우만 사용 가능! 클래스 선언 필요없이 메서드만 선언해줘도 됨.
		Collections.sort(list, (o1, o2) -> o1.getSalary() - o2.getSalary());
		
		for (Employee emp : list) {
			System.out.println(emp.getEmail() + ":" + emp.getSalary());
			
		}
	}
	
	
}

// Comparator<T> 인터페이스 상속
class EmpComp implements Comparator<Employee> {
	
	@Override
	public int compare(Employee o1, Employee o2) {
		// 결과값은 o1이 클 경우 양수, o2가 클 경우 음수.
		return o1.getEmail().compareTo(o2.getEmail());
		
	}
	
}

