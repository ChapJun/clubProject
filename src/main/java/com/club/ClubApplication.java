package com.club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@SpringBootApplication
//@EnableJpaRepositories("com.club.persistence")
//@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class ClubApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ClubApplication.class, args);
		
	}
	
	
	
	
//	Person p = new Person();
//
//	p.setId("sangi11");
//	p.setPw("a123456");
//	p.setName("양성호");
//	p.setTel("010-3234-5968");
//	p.setBelong("경영지원팀");
//	p.setPerson_img("");
//	p.setAuthority(1L);
//	p.setIntro("안녕하세요 강사님");
//
//	System.out.println();
//	System.out.println(p);
//	System.out.println();
//	// insert
//	personRepo.save(p);

}
