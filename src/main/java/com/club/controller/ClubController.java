package com.club.controller;

import java.security.Principal;
import java.util.ArrayList;
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
import com.club.domain.Schedule;
import com.club.service.ClubService;
import com.club.service.PersonService;
import com.club.service.RegistrationService;
import com.club.service.ScheduleService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private RegistrationService regiService;

	@Autowired
	private PersonService personService;

	@Autowired
	private ScheduleService scheService;

	@GetMapping("/clubManage")
	public void clubManage(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

//		
//		if(menu.equals("schedule")) {
//			List<Schedule> scList = scheService.getScheduleList(club);
//			model.addAttribute("schedule", scList);
//		}
//		else if(menu.equals("album")) {
//			
//		}
//		else { // member
//			
//		}
		

	}

	@GetMapping("/clubMain")
	public void clubMain(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

		List<Schedule> scList = scheService.getScheduleList(club);
		model.addAttribute("schedule", scList);

		List<Registration> regList = regiService.findRegiByClub(club.getCid());

		List<Person> perList = new ArrayList<>();

		for (Registration registration : regList) {
			Person person = personService.findByPersonId(registration.getPerson().getPerson_id());
			perList.add(person);
		}

		model.addAttribute("people", perList);
	}
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
	public void clubIntro(Model model, @RequestParam(value = "category", required = false) String category,
			@PageableDefault Pageable pageable) {

		Page<Club> clubList;

		if (category == null) {
			clubList = clubService.getClubList(pageable);
		} else {
			clubList = clubService.getClubByCategory(pageable, category);
		}

		model.addAttribute("clubList", clubList);
		model.addAttribute("totalPages", clubList.getTotalPages());
	}

	@GetMapping("/clubDetail")
	public void clubDetail(Model model, @RequestParam(value = "cname", required = false) String cname) {
		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);
	}

	@PostMapping("/clubDetail/Apply")
	public String clubDetailApply(@Valid Club club, Principal prin) {

		// registration 등록. rid, cid, pid, enabled
		// cid pid

		String username = prin.getName();
		Person person;
		if (username != null)
			person = personService.getPerson(username);
		else
			person = personService.getPerson("jun"); // null 처리

		Registration regi = new Registration();
		regi.setPerson(person);
		regi.setClub(club);

		regiService.insertRegistraion(regi);

		return "redirect:/clubIntro";
	}
}
