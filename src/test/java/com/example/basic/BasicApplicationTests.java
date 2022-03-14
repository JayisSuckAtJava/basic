package com.example.basic;

import java.util.List;
import java.util.Map;

import com.example.basic.dao.SunbyulDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BasicApplicationTests {
	// JUnit - 단위 테스트 ( <=> 통합 테스트)
	//           	기능별 - 전체
	// Test 에서 상황/데이터 는 확인 후 소멸됨.
	// 하지만 JUnit 은 데이터-상황에 따른 기록을 남길수 있음.
	// 		 업데이트(Upgrade)를 수행 시 이전 환경으로 다시 확인 가능.
	// Test Driven Development  - 테스트 주도 개발 => 실패 하는 경우를 먼저 작성
	// DDD(DomainDD) BDD(BehaviouurDD) 유사품 

	@Autowired
	SunbyulDao sunbyulDao;

	@Test
	void contextLoads() {
		int startRow = 15000;
		System.out.println();
		List<Map<String, Object>> result = sunbyulDao.sel(startRow);
		System.out.println("1번째 셀렉트문 실행 결과 [  "+result+"  ]  ");
		List<Map<String, Object>> rereuslt = sunbyulDao.sel2();
		System.out.println("2번째 셀렉트문 실행 결과  [  "+rereuslt+"  ]  ");
		
	}

}
