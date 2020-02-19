package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Club;
import com.club.domain.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long>{
	
//	@Query("select s from Schedule s where rownum <= 4 order by s.wdate desc")
	List<Schedule> findAll();
	
	List<Schedule> findTop4ByClubOrderByWdateAsc(Club club);
	
	@Query("select s from Schedule s where s.scid=?1")
	Optional<Schedule> findByScId(Long scid);
	
}
