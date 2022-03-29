package com.prod.emp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO extends DAO {
	public List<Employee> empList() {
		List<Employee> employees = new ArrayList<Employee>();
		
		conn = getConnect();
		try {
			psmt = conn.prepareStatement("select * from emp_java");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt("employee_id"));
				emp.setFirstName(rs.getString("first_name"));
				emp.setLastName("last_name");
				emp.setHireDate(rs.getString("hire_date").substring(0, 10));
				
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return employees;
	}
}
