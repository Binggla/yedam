package com.yedam.myserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.myserver.emp.vo.Employee;

@RestController
public class ajaxController {
	
	@GetMapping("req")
	public String reqGet(Employee vo) {
		System.out.println(vo.getFirst_name());
		return "get";
	}
	
	@PostMapping("req")
	public String reqPost(@RequestBody Employee vo) {
		//Thread.sleep(3000);
		System.out.println(vo.getFirst_name());
		return "post";
	}
}