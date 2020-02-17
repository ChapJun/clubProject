package com.club.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.domain.Club;
import com.club.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
	List<Schedule> findAll();
	List<Schedule> findByClub(Club club);
}
