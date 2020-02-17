package com.club.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.club.domain.Club;
import com.club.domain.Person;
import com.club.domain.Registration;
import com.club.service.ClubService;
import com.club.service.PersonService;
import com.club.service.RegistrationService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;
	
	@Autowired
	private RegistrationService regiService;

	@Autowired
	private PersonService personService;
	
//	@GetMapping("/clubIntro")
//	public void clubIntro(Model model, @RequestParam(value="category", required = false) String category) {
//		
//		List<Club> clubList;
//		if(category == null) {
//			clubList = clubService.getClubList();
//		}
//		else {
//			clubList = clubService.getClubByCategory(category);
//		}
//		
//		model.addAttribute("clubList", clubList);			
//	}
	
	@GetMapping("/clubIntro")
	public void clubIntro(Model model, @RequestParam(value="category", required = false) String category,
			@PageableDefault Pageable pageable) {
		
		Page<Club> clubList;
		
		if(category == null) {
			clubList = clubService.getClubList(pageable);
		}
		else {
			clubList = clubService.getClubByCategory(pageable, category);
		}
		
		model.addAttribute("clubList", clubList);
		model.addAttribute("totalPages", clubList.getTotalPages());
	}
	
	@GetMapping("/clubDetail")
	public void clubDetail(Model model, @RequestParam(value="cname", required = false) String cname) {
		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);
	}
	
	@PostMapping("/clubDetail/Apply")
	public String clubDetailApply(@Valid Club club, Principal prin) {
		
		// registration 등록. rid, cid, pid, enabled
		// cid pid
		
		String username = prin.getName();
		Person person;
		if(username != null)
			person = personService.getPerson(username);
		else
			person = personService.getPerson("jun");
		
//		Club club = new Club();
//		club.setCid((Long)param.get("cid"));
//		club.setCname((String)param.get("cname"));
//		club.setCategory((String)param.get("category"));
//		club.setClub_img((String)param.get("club_img"));
//		club.setContent((String)param.get("content"));
		
		Registration regi = new Registration();
		regi.setPerson(person);
		regi.setClub(club);
		
		regiService.insertRegistraion(regi);
		
		return "redirect:/clubIntro";
	}
}
