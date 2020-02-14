package com.club.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.club.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

	
	
}
