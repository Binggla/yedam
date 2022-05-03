package co.dev.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberUpdateControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		System.out.println("수정 작업");
		
	}

}
