package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Night_Pharmacy {
	
	@Id
	private int id;
	private String name,tel,mon,tue,wed,thu,fri,sat,sun;
	@Column(name="road_address")
	private String roadAddress;
	@Column(name="jibun_address")
	private String jibunAddress;
	@Column(name="pub_day")
	private String pubDay;

}
