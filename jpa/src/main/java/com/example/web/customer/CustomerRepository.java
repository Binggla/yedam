package com.example.web.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
													//<class name, pk type>
	public List<Customer> findByName(String name);
	
	@Query("select u from Customer u where u.name like ?1%")
	List<Customer> findByAndSort(String name);
}
