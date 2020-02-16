package com.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.domain.Club;
import com.club.service.ClubService;

@Controller
public class MainController {

	@Autowired
	private ClubService clubSerivce;
	
	@GetMapping("/clubIntro")
	public void clubIntro(Model model) {
		
		List<Club> clubList = clubSerivce.getClubList();
		model.addAttribute("clubList", clubList);
	}
	
	@GetMapping("/recruitment_Board") 
	public void recruitment_Board() {
		
	}
}
