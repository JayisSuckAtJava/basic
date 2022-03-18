package com.example.basic.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.basic.model.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long>{
				// JpaRepository<T,ID> object , ID-TYPE  T 에는 사용될 테이블 이름(demo) demo table의 id type(long seq);
				// mybatis 로 치면 result 타입인 demo 와 parameterType 의 long 이 되버리는거임...!!

	
	// save find delete - 3개의 기본 제공 메소드
	// c r u d 에서 create 와 update 는 save 로 실행함.
	// read - find  `` `` `` d - delete
	
	//entitiy 클래스에 있는것에 따라서 실행됨. user 를 가지고 있기에 할수 있고 변수또한 동일하게.
	List<Demo> findByUser(String user);
	// and 를 사용하여 붙임
	List<Demo> findByUserAndSeq(String user,long seq);
	// containing 을 통한 like 키워드는 계속 붙일수 있음, 연산도 앞에서 부터 시작함.
	List<Demo> findByUserContaining(String user);
	
	//page 로 리턴하면 여러가지 장점이 있다?
	Page<Demo> findByOrderByUserDesc(Pageable page);
	
	
	
	
	
	
	// 이런식으로 수기 쿼리 가능.
	/*@Query(nativeQuery = true,value="")
	List<Demo> anything(String user);*/
}
