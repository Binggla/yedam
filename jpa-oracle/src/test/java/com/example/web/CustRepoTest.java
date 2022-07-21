package com.example.web;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.web.customer.Customer;
import com.example.web.customer.CustomerRepository;

@SpringBootTest
public class CustRepoTest {
	
	@Autowired CustomerRepository custRepo;
	
	@Transactional
	@Commit
	//@Test
	public void saveTest() {
		Customer cust = new Customer();
		cust.setId(2L);
		cust.setPhone("234-2345");
		custRepo.save(cust);
	}
	
	@Transactional
	@Commit
	@Test
	public void updateTest() {
		// Optional : java.util. null 체크 위해서 사용?
		Optional<Customer> cust = custRepo.findById(2L);
		Customer resultCust = cust.get();
		resultCust.setPhone("345-3456");
		custRepo.save(resultCust);
		
	}
}
