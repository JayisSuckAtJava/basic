package com.example.basic.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Demo {

	@Id // seq 는 pk 가 맞지만, table에서 설정된 값이 자동증가 (auto_incre) 가 아니기 때문에 아래 라인은 설정하지 않음.
	//@GeneratedValue(strategy = GenerationType.AUTO) // GeneratedValue 는 자동생성 값 (seq같은) (안에는) 해당 db에 맞는 적당한 값
	private long seq;
	private String user;
	// Bigint == long    varchar = string
}
