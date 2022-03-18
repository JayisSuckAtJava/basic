package com.example.basic.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.basic.model.Night_Pharmacy;
@Repository
public interface Night_PharmacyRepository extends JpaRepository<Night_Pharmacy, Integer> {
					// 시부랄 jpa 는 method 이름이 쿼리문 틀 작성이라 시부랄 메소드 지 맘에 안들면 안됨.
	//List<Night_Pharmacy> FindByRoadAddressContainingAndJibunAddressContaining(String roadAddress,String jibunAddress);
	//List<Night_Pharmacy> FindByRoadAddressContaining(String roadAddress);
	List<Night_Pharmacy> findByRoadAddressContainingOrJibunAddressContaining(String roadAddress,String jibunAddress,Pageable pageable);
		// 	find 가 select , By 가 where 	RoadAddress Like ? 		Or 	JibunAddress Like ? 
		// 				Containing 이 Like 와 같이 해당 Value 가 인자를 포함하는가 를 물어본다

	// 정렬을 이런순으로 할수있다  `` 메소드를 기준으로
	List<Night_Pharmacy> findByRoadAddressContainingOrJibunAddressContainingOrderByIdDesc(String roadAddress,String jibunAddress,Pageable pageable);
}