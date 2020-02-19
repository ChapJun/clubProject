package com.club.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Club;
import com.club.domain.Schedule;
import com.club.persistence.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheRepo;
	
	public List<Schedule> getScheduleList() {
		return (List<Schedule>) scheRepo.findAll();
	}
	
	public List<Schedule> getScheduleList(Club club) {
		return (List<Schedule>) scheRepo.findTop4ByClubOrderByWdateAsc(club);
	}
	
	public void insertSchedule(Schedule sche) {
		scheRepo.save(sche);
	}
	
	public Schedule getByIdSchedule(Long scid) {
		
		Optional<Schedule> sche = scheRepo.findByScId(scid);
		return sche.get();
			
	}
	
	public void deleteSchedule(Long scid) {
		scheRepo.deleteById(scid);
	}
	
	public void updateSchedule(Schedule sche) {
		
		Schedule schedule = getByIdSchedule(sche.getScid());
		
		schedule.setWdate(sche.getWdate());
		schedule.setContent(sche.getContent());
		schedule.setLocation(sche.getLocation());
		
		scheRepo.save(schedule);
	}
}
