package com.example.basic;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.model.Demo;
import com.example.basic.repository.DemoRepository;

@SpringBootTest
class DemoRepositoryTests {
	
	
	
	
	 @Autowired
	    DemoRepository demoRepository;

	@Test
	public void select()
	{
		System.out.println(demoRepository.findAll());
	}
	
	@Test
	public void insert() { // S entity - entity 라고 칭하면 extends 한 Jpa 에 <T,ID> T 이다! entitiy 클래스 이기도 하다!
		Demo demo = new Demo();
		demo.setSeq(8L);
		demo.setUser("hi");
		demoRepository.save(demo);
	}
	
	@Test
	public void update() { // 야매 
		Demo demo = demoRepository.findById(4L).get();
		demo.setUser("DDD");
		demoRepository.save(demo);
	}
	
	@Test
	public void update2() { //진또
		Demo demo = new Demo();
		demo.setSeq(8L);
		demo.setUser("HHH");
		demoRepository.save(demo);
	}
	
	@Test
	public void USER찾기() {
		List<Demo> list = demoRepository.findByUser("CCC");
		System.out.println(list);
	}
	
	@Test
	public void user() {
		List<Demo> list = demoRepository.findByUserAndSeq("CCC", 3L);
		System.out.println(list);
	}
	
	@Test
	public void userInclude() {
		List<Demo> list = demoRepository.findByUserContaining("s");
		System.out.println(list);
	}

}
