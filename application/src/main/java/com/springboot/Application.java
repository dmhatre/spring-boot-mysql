package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
		Object[] obj = {Application.class,HelloController.class};
        SpringApplication.run(obj, args);
    }
}
