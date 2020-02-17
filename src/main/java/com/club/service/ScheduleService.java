package com.club.service;

import java.util.List;

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
		return (List<Schedule>) scheRepo.findByClub(club);
	}
	
}
