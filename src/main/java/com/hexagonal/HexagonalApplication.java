package com.hexagonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HexagonalApplication {

	public static void main(String[] args) {

		// ApplicationContext context = new ClassPathXmlApplicationContext(new String[]
		// { "META-INF/services.xml" });
		SpringApplication.run(HexagonalApplication.class, args);

	}

}
