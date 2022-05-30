package co.dev.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.dev.service.MemberService;
import co.dev.vo.MemberVo;

public class MemberListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/json;charset=utf-8");
		
		MemberService service = new MemberService();
		List<MemberVo> list = service.memberList();
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(list));

	}

}
