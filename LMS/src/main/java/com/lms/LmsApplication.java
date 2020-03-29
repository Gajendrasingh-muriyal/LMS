package com.lms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LmsApplication {

	private static Logger logger = LoggerFactory.getLogger(LmsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
		logger.info("LMS Application started check all functionalities");

	}

}
