package com.example.web.employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Employees {
	
	@Id
	Integer employee_id;
	String first_name;
	String last_name;
	String email;
	String phone_number;
	Date hire_date;
	String job_id;
	Double salary;
	Double commission_pct;
	Integer manager_id;
	// Integer department_id; -> 다대일 관계로 아래처럼 연결.
	
	@ManyToOne
	@JoinColumn(name="department_id")
	Departments departments;
	
}
