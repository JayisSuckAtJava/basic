package com.example.basic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.basic.interceptor.SignInCheckInterceptor;

//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	
	
	@Autowired
	private SignInCheckInterceptor signInCheckInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 등록한다 . 인터셉터 종류 . 패턴을 사용
		// 패턴은 url을 명시함.		전체는 ("/**")
		// .excludePathPatterns("x") 로 예외 만들수 있음. 
		registry.addInterceptor(signInCheckInterceptor).addPathPatterns("/main");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
}