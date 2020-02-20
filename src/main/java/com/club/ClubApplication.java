package com.club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
//@EnableJpaRepositories("com.club.persistence")
//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class ClubApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ClubApplication.class, args);
	}
	
	

}
