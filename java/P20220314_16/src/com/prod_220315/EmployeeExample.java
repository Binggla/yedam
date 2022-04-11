package com.prod_220315;

class Employee {
	// 필드
	private int employeeId;
	private String employeeName;
	private String department;
	private String job;
	private int salary;

	// 메소드
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return this.employeeName;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return this.job;
	}

	public void setSalary(int salary) { // private로 선언된 salary에 값을 담는 메소드
		if (salary < 0) {
			this.salary = 10000;
		} else {
			this.salary = salary;
		}
	}

	public int getSalary() { // salary 값을 출력해주는 메소드 (why? private이기 때문에 main class에서 직접 접근 불가.)
		return this.salary;
	}

	public String getEmpInfo() {
		String result = (this.employeeName + "의 부서는 " //
				+ this.department + "이고, 직무는 " + this.job //
				+ "입니다. 급여는 " + this.salary + "원입니다.");
		return result;
	}

}

public class EmployeeExample { // public(<-> private)

	public static void main(String[] args) {

		Employee e1 = new Employee();

//		e1.employeeId = 100;
//		e1.employeeName = "김사원";
//		e1.department = "개발부";
//		e1.job = "월급 계산";
//		e1.salary = -1000000;	

		// Employee class에서 private로 선언되어있기 때문에 main class에서 바로 변수를 선언할 수 없다.
		// 아래처럼 메소드를 통해서 변수 선언을 할 수 있도록 한다.

		e1.setEmployeeId(100);
		e1.setEmployeeName("김사원");
		e1.setDepartment("재경부");
		e1.setJob("월급 계산");
		e1.setSalary(1000000);

		System.out.println(e1.getEmpInfo());
		
		Employee e2 = new Employee();
		
		e2.setEmployeeId(101);
		e2.setEmployeeName("지사원");
		e2.setDepartment("개발부");
		e2.setJob("웹 서버 관리");
		e2.setSalary(3000000);

		System.out.println(e2.getEmpInfo());

	}

}
