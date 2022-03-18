package com.example.basic.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j  // log 를 사용하기 위한 어노테이션 생성-lombok 내장
@Aspect// Aop 를 사용하는 Aspect 생성.
@Component // Bean 으로 등록하기 위한 어노테이션
public class ControllerAspect { //pcom.example.basic.controller;
	@Before(value = "execution (* com.example.basic.controller.*.*(..))")
	public void onBeforeHandler(JoinPoint joinPoint) {
		log.debug("@Before run");
	}
	@After(value = "execution (* com.example.basic.controller.*.*(..))")
	public void onAfterHandler(JoinPoint joinPoint) {
		log.debug("@After run");
	}
	@AfterReturning(value = "execution (* com.example.basic.controller.*.*(..))",returning = "data")
	// AfterReturning 은 Return 이 발생 할때 마다 실행을 하며 returning = "x" 로 Handler에 x 파라미터로 받을수 있다.
	// 그래서 아래 메소드에 data 같은 경우 data가 null 이 아닌 리턴이 있는경우 toString 콘솔에 찍어주는 기능 수행중.
	public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
		if (data != null) {
			log.debug(data.toString());
		}
		log.debug("@AfterReturning run");
	}
	// around = before after afterReturining after-throwing 4개 모두
/*	@Around(value = "execution (* com.example.basic.controller.*.*(..))")
	public Object around(ProceedingJoinPoint join)	{
		log.debug("@around");
		Object obj=null;
		try {
			obj = join.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
		
	}*/
	
	
}