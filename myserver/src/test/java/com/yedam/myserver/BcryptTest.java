package com.yedam.myserver;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTest {
	
	@Test
	public void test() {
		// 강도를 입력하여 암호화 속도를 조절할 수 있다.
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
		
		String result = encoder.encode("1111");
		System.out.println(result);
		
		// 패스워드 비교. 반드시 matches() 메서드를 사용하여 비교한다.
		assertTrue(encoder.matches("1111", result));
	}
	
}
