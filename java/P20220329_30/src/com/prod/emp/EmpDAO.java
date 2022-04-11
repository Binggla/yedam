package com.prod.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	
	// 전체 리스트
	public List<Employee> empList() {
		List<Employee> employees = new ArrayList<Employee>();
		
		conn = getConnect();
		String sql = "select * from emp_java";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setJobId(rs.getString("job_id"));
				
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return employees;
	}
	
	// 중복 체크
	public String searchEmpId(int empId) {
		
		List<Employee> list = empList();
		for (Employee e : list) {
			if (e.getEmployeeId() == empId) {
				return "same";
			}
		}
		return "not same";
	}
	
	// 한 건 조회
	public Employee getOneEmp(int empId) {
		
		conn = getConnect();
		Employee emp;
		String sql = "select * from emp_java "
				+ "where employee_id = ?";
		try {
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empId);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName(rs.getString("last_name"));
				emp.setEmail(rs.getString("email"));
				emp.setPhoneNumber(rs.getString("phone_number"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				emp.setJobId(rs.getString("job_id"));
				
				return emp;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return null;
		
	}
	
	// 입력 처리
	// insert, executeUpdate()
	public boolean insertEmp(Employee emp) {
		
		
			conn = getConnect();
			
			// 쿼리문을 작성하며 매개변수가 들어갈 곳을 ?로 지정한다.
			String sql = "insert into emp_java (employee_id, last_name, email, hire_date, job_id) \r\n"
					+ "values (?, ?, ?, ?, ?)";
			try {
				
				// 쿼리문의 ? 자리에 들어갈 매개변수 값을 지정한다.
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, emp.getEmployeeId());	// ? <= 매개변수 값 중에서 employeeId 필드값
				psmt.setString(2, emp.getLastName());
				psmt.setString(3, emp.getEmail());
				psmt.setString(4, emp.getHireDate());
				psmt.setString(5, emp.getJobId());
				
				int r = psmt.executeUpdate();			// 실행된 건 수 반환.
				System.out.println(r + "건 입력!");
				if (r > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// finally : 반드시 한 번은 실행하는 코드
				disconnect();
			}
			
			return false;
		
	}
	
	// 수정 처리 : update
	public boolean updateEmp(Employee emp) {
	
			conn = getConnect();
			
			String sql = "update emp_java " //
					+ "set first_name = ?, " //
					+ "    phone_number = ?, " //
					+ "    salary = ? " //
					+ "where employee_id = ?";
			
			try {
				
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, emp.getFirstName());
				psmt.setString(2, emp.getPhoneNumber());
				psmt.setInt(3, emp.getSalary());
				psmt.setInt(4, emp.getEmployeeId());
				
				int r = psmt.executeUpdate();
				System.out.println(r + "건 수정!");
				if (r > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
			
	}
	
	// 삭제 처리 : delete
	// ID를 기준으로 삭제
	public boolean deleteEmp(int empId) {

			conn = getConnect();
			String sql = "delete from emp_java "
					+ "where employee_id = ?";
			
			try {
				
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, empId);
				
				int r = psmt.executeUpdate();			
				System.out.println(r + "건 삭제!");
				if (r > 0) {
					return true;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				disconnect();
			}
			return false;
			
	}
	
}
