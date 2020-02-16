package com.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.club.domain.Club;
import com.club.service.ClubService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;
	
	@GetMapping("/clubIntro")
	public void clubIntro(Model model, @RequestParam(value="category", required = false) String category) {
		
		List<Club> clubList;
		if(category == null) {
			clubList = clubService.getClubList();
		}
		else {
			clubList = clubService.getClubByCategory(category);
		}
		model.addAttribute("clubList", clubList);			
	}
	
}
