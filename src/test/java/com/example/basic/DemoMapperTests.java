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
	@Autowired // AutoWired를 사용하기 위해선 Spring Container 에 bean 으로 등록되어야 한 다람쥐.
	DemoMapper demoMapper;

	@Test
	public void select() {

		List<Map<String, Object>> result = demoMapper.select();
		System.out.println(result + "이게 테스트다 이말이야.");
		int count = 1;
		for (Map<String, Object> i : result) {
			System.out.println(count++ + " 번째 : " + i);
			// is the fucking vscode can read this? or rest in temp?
			// is can make sync
			// 참조 자료형 처럼 같은곳을 바라보고 있드아? ( 참조 자료형 과 유사품 != 기본 자료형 )
		}
	}

	@Test
	public void insert() {
		Map<String, Object> map = new HashMap<>();
		map.put("seq", 8);
		map.put("user", "who");
		int result = demoMapper.insert(map);
		System.out.println(result);
	}

}
