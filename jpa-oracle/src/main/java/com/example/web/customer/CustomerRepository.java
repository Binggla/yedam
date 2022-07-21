package com.example.web.customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
//	@PersistenceContext
//	EntityManager em;
//	
//	//update : merge
//	//insert : persist
//	//find : select
//	public void save(Customer cust) {
//		em.persist(cust);
//	}

}
