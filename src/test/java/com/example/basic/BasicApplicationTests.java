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

	// Junit 은 SpringBootTest Class 안에 있는 Test Method를 단독 실행함. (클래스를 선택하면 안에 메소드 전부 실행.)
	// 클래스(파일) 명칭은 주로 테스트할 객체의 이름을 기주능로 만드는 편, method는 해당 객체의 메소드 들로 구성
	// 예:) SunbyulDaoTest 런식. - @Test void method(){} 런식
	// + AutoWired로 모든 Bean 대려올수 있음.

	@Test
	void contextLoads() {
		int startRow = 15000;
		System.out.println();
		List<Map<String, Object>> result = sunbyulDao.sel(startRow);
		System.out.println("1번째 셀렉트문 실행 결과 [  "+result+"  ]  ");	
	}

	@Test
	void sunbyulSelect(){
		List<Map<String, Object>> rereuslt = sunbyulDao.sel2();
		System.out.println("2번째 셀렉트문 실행 결과  [  "+rereuslt+"  ]  ");
	}

}
