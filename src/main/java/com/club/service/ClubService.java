package com.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Club;
import com.club.persistence.ClubRepository;

@Service
public class ClubService {

	@Autowired
	private ClubRepository clubRepo;
	
	public List<Club> getClubList() {
		return (List<Club>) clubRepo.findAll();
	}
	
	public Club getClub(long cid) {
		Optional<Club> optional = clubRepo.findByCid(cid);
		Club club = optional.get();
		
		return club;
	}
	
	public List<Club> getClubByCategory(String category) {
		return (List<Club>) clubRepo.findByCategory(category);
	}
}
