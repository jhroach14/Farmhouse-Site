package com.webu.urban;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FarmhouseApplication {

	private final static Logger log = LoggerFactory.getLogger(FarmhouseApplication.class);

	//initializes application
	public static void main(String[] args) {
		log.debug("Application Starting...");
		SpringApplication.run(FarmhouseApplication.class, args);
	}
}
