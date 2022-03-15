package com.example.basic.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity // jpa 에게 선언
public class Any {
	@Id //pk 로 선언 한다는 어노테이션? not null 은 기본인듯?
    private String name;
    private int age;
}
