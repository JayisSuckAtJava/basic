package com.example.basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
