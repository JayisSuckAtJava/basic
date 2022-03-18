package com.example.basic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Team {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	//자기를 부르는 변수를 문자열로 작성 ( Player.team )
	// n : 1 을 지정할때 1의 입장에선 OneTOmany 1:n 을 지정함과 동시에
	// 지정 대상이기에 mappedby 로 쓴다
	// 다수가 지정할 대상이기에 list 로 받았다.
	@OneToMany(mappedBy = "team", fetch=FetchType.EAGER)
	List<Player> players = new ArrayList<>();
}