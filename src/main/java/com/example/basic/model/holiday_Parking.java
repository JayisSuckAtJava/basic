package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class holiday_Parking {
	@Id
	private int id;
	private String institution;
	private String manager;
	private String tel;
	private String sido;
	private String gu;
	private String address;
	private String name;
	private String loc;
	private String type;
	private String lng;
	private String lat;
	private String etc;
}
