package com.prod.emp;

import java.util.List;
import java.util.Scanner;

public class EmpExe {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		EmpDAO dao = new EmpDAO();
		
		// 메뉴  1. 사원리스트 2. 입력 3. 수정 4. 삭제 5. 한 건 조회 9. 종료
		while (true) {

			System.out.println("---------------------------------------------------");
			System.out.println(" 1. 사원리스트 2. 입력 3. 수정 4. 삭제 5. 한 건 조회 9. 종료");
			System.out.println("---------------------------------------------------");
			System.out.print(" 선택 > ");
			
			int inputMenu = scan.nextInt();
			
			if (inputMenu == 1) {	// 사원리스트
				
				List<Employee> list = dao.empList();
				
				System.out.println("\n[ 사원리스트 ]\n");
				for (Employee emp : list) {
					System.out.println(emp.toString());
				}
				
			} else if (inputMenu == 2) {	// 입력
				// 사원번호, lastName, email, hireDate, jobId
				
				System.out.println("\n[ 사원 등록 ]\n");
				
				Employee emp = null;
				int employeeId = 0;
				while (true) {
					System.out.print("Employee ID >> ");
					employeeId = scan.nextInt();
					if (dao.searchEmpId(employeeId).equals("same")) {
						System.out.println("중복되는 사원 번호가 있습니다.");
						continue;
					}
					break;
				}
					
				System.out.print("Last Name >> ");
				String lastName = scan.next();
				System.out.print("Email >> ");
				String email = scan.next();
				System.out.print("Hire Date >> ");
				String hireDate = scan.next();
				System.out.print("Job ID >> ");
				String jobId = scan.next();
				
				emp = new Employee(employeeId, null, lastName, email, null, 0, hireDate, jobId);
				//				emp.setEmployeeId(employeeId);
				//				emp.setLastName(lastName);
				//				emp.setEmail(email);
				//				emp.setHireDate(hireDate);
				//				emp.setJobId(jobId);
				
				boolean result = dao.insertEmp(emp);
				if (result == true) {
					System.out.println("정상적으로 처리되었습니다.");
				} else if (result == false) {
					System.out.println("정상적으로 처리되지 않았습니다.");
				}
				
				
				
				
			} else if (inputMenu == 3) {	// 수정
				
				
				
				System.out.println("\n[ 사원 정보 수정 ]\n");
				
				Employee emp = null;
				int employeeId = 0;
				while (true) {
					System.out.print("Employee ID >> ");
					employeeId = scan.nextInt();
					if (dao.searchEmpId(employeeId).equals("not same")) {
						System.out.println("해당하는 사원 번호가 없습니다.");
						continue;
					}
					break;
				}
				
				System.out.print("First Name >> ");
				String firstName = scan.next();
				System.out.print("Phone Number >> ");
				String phoneNumber = scan.next();
				System.out.print("Salary >> ");
				int salary = scan.nextInt();
				
				Employee e = new Employee(employeeId, firstName, null, null, phoneNumber, salary, null, null);
				//				emp.setFirstName(firstName);
				//				emp.setPhoneNumber(phoneNumber);
				//				emp.setSalary(salary);
				
				boolean result = dao.updateEmp(e);
				if (result == true) {
					System.out.println("정상적으로 처리되었습니다.");
				} else if (result == false) {
					System.out.println("정상적으로 처리되지 않았습니다.");
				}
				
			
					
			} else if (inputMenu == 4) {	// 삭제
				
				System.out.println("\n[ 사원 정보 삭제 ]\n");
				
				Employee emp = null;
				int employeeId = 0;
				while (true) {
					System.out.print("Employee ID >> ");
					employeeId = scan.nextInt();
					if (dao.searchEmpId(employeeId).equals("not same")) {
						System.out.println("해당하는 사원 번호가 없습니다.");
						continue;
					}
					break;
				}
				
				boolean result = dao.deleteEmp(employeeId);
				if (result == true) {
					System.out.println("정상적으로 처리되었습니다.");
				} else if (result == false) {
					System.out.println("정상적으로 처리되지 않았습니다.");
				}
				
				
				
			} else if (inputMenu == 5) {	// 한 건 조회
				
				System.out.println("\n[ 사원 정보 한 건 조회 ]\n");
				System.out.print("Employee ID >> ");
				int employeeId = scan.nextInt();
				
				Employee emp = dao.getOneEmp(employeeId);
				
				if (emp == null) {
					System.out.println("해당하는 사원 번호가 없습니다.");
				} else if (emp != null) {
					System.out.println(emp);
				}
				

			} else if (inputMenu == 9) {	// 종료
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}	// end of while
		
		
		
		System.out.println("end of program!");
		scan.close();
		
	} // end of main()

}
