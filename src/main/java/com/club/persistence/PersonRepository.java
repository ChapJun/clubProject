package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.club.domain.Club;
import com.club.domain.Person;
import java.lang.Long;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

	List<Person> findAll();
	Optional<Person> findById(String id);
	
	@Query("select p from Person p where p.person_id=?1")
	Optional<Person> findByPersonId(Long person_id);
	
//	@Query(value = "select club_id, category, club_img, cname, content, intro, state"
//			+ " from registration join club using(club_id) where person_id=?1", nativeQuery = true)
//	Object[] findMyClubs(Long person_id);
	
	@Query("SELECT r.club FROM Registration r where r.person.person_id=?1")
	List<Club> findMyClubs(Long person_id);
	
}
