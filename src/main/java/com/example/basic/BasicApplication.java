package com.example.basic;

import java.io.IOException;

import com.example.basic.util.ImageUtil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicApplication.class, args);
/*		String path = "http://ggoreb.com/images/luffy.jpg";
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		ImageUtil image = (ImageUtil) context.getBean("imageUtil");
		try {
			image.save(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		((AnnotationConfigApplicationContext) context).close();
	}
*/}
}
