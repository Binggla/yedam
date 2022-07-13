package com.example.web.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {
	@Autowired CustomerRepository dao;
	
	@RequestMapping("/custList")
	public String custList(Model model) {
		
		//find: select
		//save: insert, update
		//delete: delete
		model.addAttribute("custList", dao.findByAndSort("1"));
		return "custList";
	}
}
