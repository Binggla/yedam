package com.example.web.employee;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Departments {
	
	@Id
	Integer department_id;
	String department_name;
	Integer manager_id;
	Integer location_id;
	
}
