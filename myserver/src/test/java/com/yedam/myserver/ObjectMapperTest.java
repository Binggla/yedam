package com.yedam.myserver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.myserver.todo.vo.TodoVO;

public class ObjectMapperTest {
	
	@Test
	public void test2() throws MalformedURLException, IOException {
		ObjectMapper om = new ObjectMapper();
		String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220614";
		JsonNode result = om.readTree(new URL(url));	
			// readTree() : 내가 받는 값의 VO 객체가 따로 없을 때 사용. 중첩구조로 구성된 값을 받아올 때 좋다.
		String nm = result.get("boxOfficeResult")
							.get("dailyBoxOfficeList")
							.get(0)
							.get("movieNm").asText();
		System.out.println(nm);
	}
	
	//@Test
	public void test1() throws JsonProcessingException {
		TodoVO vo = new TodoVO();
		vo.setContents("test");
		vo.setNo("1");
		
		ObjectMapper om = new ObjectMapper();
		String result = om.writeValueAsString(vo);  // @ResponseBody : 자바 객체 -> 스트링(json)
		System.out.println(result); // {"no":"1","contents":"test"}
		
		TodoVO vo2 = om.readValue(result, TodoVO.class);  // @RequestBody : 스트링(json) -> 자바 객체
		System.out.println(vo2.getContents());
	}
}
