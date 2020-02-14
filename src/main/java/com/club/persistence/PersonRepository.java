package com.club.persistence;

import org.springframework.data.repository.CrudRepository;

import com.club.domain.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

	
	
}
