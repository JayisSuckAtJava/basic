package com.example.basic.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class MyBatisLogAspect {

	
	@AfterReturning(value = "execution (* com.example.basic.controller.DBController.mybatis*(..))",returning = "data")
	public void myBatisMethod(Object data) {
		if(data!=null) { log.info(data.toString());}
		log.info("---@Mybatis Has a been done---");
	}
}
