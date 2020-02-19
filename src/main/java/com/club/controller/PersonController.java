package com.club.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.domain.Club;
import com.club.domain.Person;
import com.club.domain.Registration;
import com.club.service.ClubService;
import com.club.service.PersonService;
import com.club.service.RegistrationService;

@Controller
public class PersonController {

	@Autowired
	private RegistrationService regiService;

	@Autowired
	private ClubService clubService;

	@Autowired
	private PersonService personService;

	@GetMapping("/memberManage")
	public void memberManage(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

		List<Registration> regList = regiService.findRegiByClub(club.getCid());

		List<Person> applyList = new ArrayList<>();
		List<Person> memberList = new ArrayList<>();
		List<Person> capList = new ArrayList<>();

		for (Registration registration : regList) {

			Person person = personService.findByPersonId(registration.getPerson().getPerson_id());

			if (registration.getEnabled() == 0) {
				applyList.add(person);
			} else if (registration.getEnabled() == 1) {
				memberList.add(person);
			} else {
				capList.add(person);
			}

		}

		model.addAttribute("applyPeople", applyList);
		model.addAttribute("memberPeople", memberList);
		model.addAttribute("capPeople", capList);
	}

	
	
}
