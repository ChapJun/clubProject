package com.club.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Club;
import com.club.domain.Person;
import com.club.domain.Schedule;
import com.club.domain.Scheduling;
import com.club.persistence.ScheduleRepository;
import com.club.persistence.SchedulingRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheRepo;
	
	@Autowired
	private SchedulingRepository schlRepo;
	
	Logger logger = LoggerFactory.getLogger(ScheduleService.class);
	
	public void insertScheduling(Scheduling schl) {
		schlRepo.save(schl);
	}
	
	public Scheduling getSchedulingByScid(Long scid) {
		return schlRepo.findById(scid).get();
	}
	
	public void deleteScheduling(Long scid) {
		schlRepo.deleteById(scid);
	}
	
	public Scheduling getSchedulingByScheduleByPerson(Schedule sche, Person person) {
		
		Optional<Scheduling> op = schlRepo.findByScheduleAndPerson(sche, person);
		
		if(op.isPresent()) {
			return op.get();
		}
		else {
			return null;
		}
		
	}
	
	public List<Schedule> getScheduleList() {
		return (List<Schedule>) scheRepo.findAll();
	}
	
	public List<Schedule> getScheduleAll(Club club) {
		return (List<Schedule>) scheRepo.findByClubOrderByWdateAsc(club);
	}
	public List<Schedule> getScheduleList(Club club) {
		
		List<Schedule> scheList = scheRepo.findByClubOrderByWdateAsc(club);
		
		long time = System.currentTimeMillis();
		Date curDate = new Date(time);
		
		List<Schedule> sList = new ArrayList<>();
		
		for (Schedule schedule : scheList) {
			
			if(curDate.compareTo(schedule.getWdate()) < 0 && sList.size() < 5)
				sList.add(schedule);
			
		}
		
		return sList;
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
	
	private List<Scheduling> getByPersonScheduling(Person person) {
		return schlRepo.findByPersonScheduling(person);
	}
	
	public List<Schedule> getByPersonScheduleList(Person person) {
		
		List<Scheduling> sclingList = getByPersonScheduling(person);
		List<Schedule> scheList = new ArrayList<>();
		
		long time = System.currentTimeMillis();
		Date curDate = new Date(time);
		
		for (Scheduling scheduling : sclingList) {
			
			Schedule sche = scheduling.getSchedule();
			
			if(curDate.compareTo(sche.getWdate()) < 0)
				scheList.add(scheduling.getSchedule());
		}
		
		Collections.sort(scheList, new Comparator<Schedule>() {

			@Override
			public int compare(Schedule o1, Schedule o2) {
				
				if(o1.getWdate().compareTo(o2.getWdate()) > 0) {
					return 1;
				}
				else if(o1.getWdate().compareTo(o2.getWdate()) < 0){
					return -1;
				}
				else 
					return 0;
				
			}
			
		});
		
//		logger.info(scheList.get(0).getWdate().toString());
		return scheList;
		
	}
}
