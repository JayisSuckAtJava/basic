package com.example.basic;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = BeanConfig.class)
public class BeanConfig {
}

/*                   1. ( 보편적으로 Lib를 1 또는 2로 함 )
                    @Configuration 을 보유한 클래스가
                    자동으로 bean을 생성하는 객체로 설정.
                    bean이 될 대상 객체는 @Bean 으로 설정,
                    BeanConfig 안에서 생성자로 생성.

                    2. ( 가장 오래된 레거시 방법 - 유지보수 만에만 쓰는 편 )
                    xml로 해당 객체를 bean으로 지정하여 import

                    3.  ( 가장 최신이며 가장 많이씀 - 하지만 Lib 를 대려다 쓸경우는 불가능. )
                    1과 유사함.
                    @ComponentScan(basePackages = "direction") 을 보유한 클래스가
                    자동으로 모든 Component가 연결될 객체로 설정.
                    bean이 될 대상 객체는 @Component 로 설정,
                    Scan의 클래스는 bean 을 import 혹은 같은 경로에 있어야함. 

 */
