package com.club;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.club.domain.Person;
import com.club.persistence.PersonRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages="com.club")
@ContextConfiguration(locations = {"classpath:spring/root-content.xml"})
public class PersonRepositoryTest {

	@Autowired
	private PersonRepository personRepo;
	
	@Test
	public void testInsertPerson() {
		
		Person p = new Person();
		
		p.setId("sangi11");
		p.setPw("a123456");
		p.setName("양성호");
		p.setTel("010-3234-5968");
		p.setBelong("경영지원팀");
		p.setPerson_img("");
		p.setAuthority(1L);
		p.setIntro("안녕하세요 강사님");
		
		System.out.println();
		System.out.println(p);
		System.out.println();
		// insert
		personRepo.save(p);
		
	}
	
}
