package com.example.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.Night_Pharmacy;
import com.example.basic.repository.Night_PharmacyRepository;

@RestController
public class NightPharmacyController {
	
	@Autowired
	Night_PharmacyRepository night_PharmacyRepository;
	
	@GetMapping("/phamacy/all")
	public List<Night_Pharmacy> all() {
		return night_PharmacyRepository.findAll();
		
	}
	
	@GetMapping("/jpa/night")
	public List<Night_Pharmacy> daejeon() {
		String roadAddress, jibunAddress;
		roadAddress = "대전";
		jibunAddress = "대전";
		//return night_PhamacyRepository.FindByRoadAddressContainingAndJibunAddressContaining(roadAddress, jibunAddress);
		//return night_PharmacyRepository.FindByRoadAddressContaining(roadAddress);
		return night_PharmacyRepository.findByRoadAddressContainingOrJibunAddressContaining(roadAddress, jibunAddress);

	}

}
