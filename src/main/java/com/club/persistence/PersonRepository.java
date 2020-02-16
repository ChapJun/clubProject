package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.domain.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	List<Person> findAll();
	Optional<Person> findById(String id);
}
