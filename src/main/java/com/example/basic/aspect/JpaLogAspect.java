package com.example.basic.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class JpaLogAspect {

	@AfterReturning(value = "execution (* com.example.basic.controller.DBController.jpa*(..))",returning = "data")
	public void jpa(Object data) {
		if(data!=null) { log.warn(data.toString());}
		log.warn("---@JPA has a been done---");
	}
}
