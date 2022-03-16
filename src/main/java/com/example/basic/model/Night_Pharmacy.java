package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Night_Pharmacy {
	
	@Id
	@GeneratedValue
	private int id;
	private String name,tel,mon,tue,wed,thu,fri,sat,sun,roadAddress,jibunAddress,pubDay;
}
