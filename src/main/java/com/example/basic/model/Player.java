package com.example.basic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude="team") // 객체인 team을 StackOverFlow 나게 하지 않기위해 ToString 을 안쓰게함.
public class Player {
	@Id 
	@GeneratedValue
	private Long id;
	@Column(name = "USERNAME")
	private String name;
	private int age;
	
	// thisColumn and That Column Many to one
	// team_id is pk on team column id
	// manyToOne => n : 1 Player 기준 n 개가 there 기준 1개 지칭.
	@ManyToOne
	@JoinColumn(name = "TEAM_ID")
	private Team team;
}