package com.example.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.basic.mapper.DemoMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoMapperTests {
	@Autowired
	DemoMapper demoMapper;

	@Test
	public void select(){

		List<Map<String, Object>> result = demoMapper.select();
		System.out.println(result+"이게 테스트다 이말이야.");
		for(Map<String, Object> i : result){
			System.out.println(i);
		}
	}

	@Test
	public void insert(){
		Map<String , Object > map = new HashMap<>();
        map.put("seq", 8);
        map.put("user", "who");
		int result =demoMapper.insert(map);
		System.out.println(result);
	}

}
