package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.club.domain.Club;
import com.club.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

	@Query ("Select r FROM Registration r where r.person.person_id=?1 and r.club.cid=?2") 
	Optional<Registration> findByRegiPerson(Long person_id, Long club_id);
	
	@Query("Select r FROM Registration r where r.club.cid=?1")
	List<Registration> findRegiByClub(Long club_id);
	
	List<Registration> findByClubAndEnabled(Club club, Long enabled);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="update registration r set r.enabled=?1 where r.rid=?2")
	void queryUpdateEnabled(Long ena, Long rid);	
}
