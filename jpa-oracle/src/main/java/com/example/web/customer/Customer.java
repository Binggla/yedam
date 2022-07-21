package com.example.web.customer;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

//lombok
@Data
//jpa
@Entity
public class Customer {
	
	// primary key
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(length = 20)
	String name;
	String phone;
	Date wdate;
}
