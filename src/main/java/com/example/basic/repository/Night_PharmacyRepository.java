package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.basic.model.Night_Pharmacy;
@Repository
public interface Night_PharmacyRepository extends JpaRepository<Night_Pharmacy, Integer> {
	
	//List<Night_Pharmacy> FindByRoadAddressContainingAndJibunAddressContaining(String roadAddress,String jibunAddress);
	//List<Night_Pharmacy> FindByRoadAddressContaining(String roadAddress);
	List<Night_Pharmacy> findByRoadAddressContainingOrJibunAddressContaining(String roadAddress,String jibunAddress);
}		// 	find 가 select , By 가 where 	RoadAddress Like ? 		Or 	JibunAddress Like ? 
		// 				Containing 이 Like 와 같이 해당 Value 가 인자를 포함하는가 를 물어본다
