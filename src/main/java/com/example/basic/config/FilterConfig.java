package com.example.basic.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.basic.filter.IPCheckFilter;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<Filter> getFilterRegistrationBean() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>(new IPCheckFilter());
		bean.addUrlPatterns("/visitor");
		return bean;
	}
}

	/* AOP 는 Spring 기술
 * 		Filter 는 was 의 기술
 * 		AOP 는 Method 대상
 * 		Filter 는 url 대상
 * 
 * 		Filter 와 Interceptor 공통점=
 * 		Url 에 적용.
 * 		Request 객체 사용이 쉬움
 * 		사용 빈도 FilteR < InterCeptor(InterCeptor 는 Spring 기술)
 * 			
 * 		Filter 의 주 사용 분야는.
 * 		XSS  , Logging  , Encoding  , IP 검사 등.
 * 
 	*/
 