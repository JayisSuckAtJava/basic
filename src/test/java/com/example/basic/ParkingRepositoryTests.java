package com.example.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.basic.repository.ParkingRepository;

@SpringBootTest
class ParkingRepositoryTests {
	@Autowired // AutoWired를 사용하기 위해선 Spring Container 에 bean 으로 등록되어야 한 다람쥐.
	ParkingRepository parkingRepository;

	@Test
	public void select() {
		System.out.println(parkingRepository.findBySido("세종"));
		

	}


}
