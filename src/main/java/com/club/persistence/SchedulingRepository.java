package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Person;
import com.club.domain.Schedule;
import com.club.domain.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long>{

	Optional<Scheduling> findByScid(Long scid);
	Optional<Scheduling> findByScheduleAndPerson(Schedule sche, Person person);
	
	@Query("select s from Scheduling s where s.person=?1")
	List<Scheduling> findByPersonScheduling(Person person);
	
	
}
