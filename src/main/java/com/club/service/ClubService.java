package com.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Page<Club> getClubList(Pageable pageable) {
		
		int page = (pageable.getPageNumber() == 0 ) ? 0 : (pageable.getPageNumber() - 1);
		 pageable = PageRequest.of(page, 5);
		 
		 return (Page<Club>) clubRepo.findAll(pageable);
	}
	
	public Club getClub(String cname) {
		Optional<Club> optional = clubRepo.findByCname(cname);
		Club club = optional.get();
		
		return club;
	}
	
	public List<Club> getClubByCategory(String category) {
		return (List<Club>) clubRepo.queryByCategory(category);
	}
	
	public Page<Club> getClubByCategory(Pageable pageable, String category) {
		
		int page = (pageable.getPageNumber() == 0 ) ? 0 : (pageable.getPageNumber() - 1);
		 pageable = PageRequest.of(page, 5);
		 
		return (Page<Club>) clubRepo.queryByCategory(category, pageable);
	}
	
}
