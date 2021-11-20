package com.springsrescuemission.kennelmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableMongoRepositories
@EnableSwagger2
@SpringBootApplication
public class KennelManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KennelManagerApplication.class, args);
	}

}
