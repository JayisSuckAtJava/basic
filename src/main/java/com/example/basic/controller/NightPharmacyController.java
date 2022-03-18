package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.Night_Pharmacy;
import com.example.basic.repository.Night_PharmacyRepository;

@RestController
public class NightPharmacyController {
	
	@Autowired
	Night_PharmacyRepository night_PharmacyRepository;
	
	@GetMapping("/pharmacy/{page}") // pathVariable /뒤에 {x}로 파라미터에 @PathVariable 에 넣는 값 @Path(x) x와x가 같으면 됩니댱
	public List<Night_Pharmacy> all(@PathVariable("page")int page) {

		Sort sort = Sort.by("name"); // name 을 기준으로 정렬시에 , 숫자 영어 가나다 순.
		Pageable p = PageRequest.of(page-1, 10,sort); // 암기해야할 구조 ( 1페이지 씩 , 10개 씩 ) 1번째 파라미터에 보여줄 페이지를 2번째 인자에 페이지당 데이터의 수
		Page<Night_Pharmacy> result =night_PharmacyRepository.findAll(p); // 페이지 네이션 한 데이터를 저장
		List<Night_Pharmacy> list = result.getContent(); // page당 들어있는 것들을 getContent() 로 불러옴
		return list;
		
	}
	
	@GetMapping("/jpa/night")
	public List<Night_Pharmacy> city(
			@RequestParam(value = "address",defaultValue = "대전",required = false) String address,
			@RequestParam(value = "page",defaultValue = "0",required = false) int page) {
		String roadAddress, jibunAddress;
		roadAddress = address;
		jibunAddress = address;
		
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		// sort 를 이용해 정렬 기준을 생성하고 sort.by("column") 으로 column  오름차순을 기본
		// List 기준을 변경할수 있다.
		// pageable 에 파라미터를 넣으면 해당 기준으로 정렬-페이징 한다.
		Pageable p = PageRequest.of(page, 5,sort);
		
		return night_PharmacyRepository.findByRoadAddressContainingOrJibunAddressContaining(roadAddress, jibunAddress,p);

	}
	
	@GetMapping("/jpa/sejong")
	public List<Night_Pharmacy> city2(
			@RequestParam(value = "address",defaultValue = "세종",required = false) String address,
			@RequestParam(value = "page",defaultValue = "0",required = false) int page) {
		String roadAddress, jibunAddress;
		roadAddress = address;
		jibunAddress = address;

		Pageable p = PageRequest.of(page, 5);
		
		return night_PharmacyRepository.findByRoadAddressContainingOrJibunAddressContainingOrderByIdDesc(roadAddress, jibunAddress,p);

	}

}
