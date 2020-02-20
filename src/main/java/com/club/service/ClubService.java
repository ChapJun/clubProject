package com.club.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.club.controller.SecurityController;
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
	
	public Long getClubIdMaxCount() {
		
		List<Object[]> objList = clubRepo.queryByClubCount();
		
		if(objList.size() > 0) {
//			Logger logger = LoggerFactory.getLogger(ClubService.class);
			
			long max = 0L;
			int index = 0;
			
			for (int i = 0; i < objList.size(); i++) {
				
				Object[] objects = objList.get(i);
				
				BigDecimal bd = (BigDecimal)objects[0];
				long cnt = bd.longValue();
				
				if(max < cnt) {
					max = cnt;
					index = i;
				}
			}
			
			
			BigDecimal bb = (BigDecimal) objList.get(index)[1];
			Long cid = bb.longValue();
			
			return cid;
		}

		
		return 1L;
	}
	
	public Club getClubById(long cid) {
		
		if(clubRepo.findById(cid).isPresent())
			return clubRepo.findByCid(cid).get();
		
		return null;
	}
}
