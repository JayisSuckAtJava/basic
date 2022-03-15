package com.example.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.basic.model.holiday_Parking;
@Repository
public interface ParkingRepository extends JpaRepository<holiday_Parking, Integer> {

	/*@Query(value = "select * from holiday_parking where sido like '%세종%'", nativeQuery = true)
	  List<holiday_Parking> findCity(String location);*/
	  
	  //List<holiday_Parking> findBySearch(String sido);
	  
	 List<holiday_Parking> findBySido(String sido);
	 // findBy 컬럼 ( 타입 값(컬럼) ) 으로 해당 컬럼에 where 컬럼 like ~ 로 된다 ! 중요하다
}
