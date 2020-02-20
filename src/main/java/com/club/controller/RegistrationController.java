package com.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.domain.Club;
import com.club.domain.Registration;
import com.club.service.ClubService;
import com.club.service.PersonService;
import com.club.service.RegistrationService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService regiService;

	@Autowired
	private ClubService clubService;

	@GetMapping("/approvalMember")
	public String approvalMember(RedirectAttributes attr, @RequestParam(value = "cname") String cname,
			@RequestParam(value = "pid") Long pid) {

		Club club = clubService.getClub(cname);
		Registration regi = regiService.getByRegiClubPerson(pid, club.getCid());

		regiService.updateEnabled(1L, regi.getRid());

		attr.addAttribute("cname", cname);

		return "redirect:memberManage";
	}

	@GetMapping("/refuseMember")
	public String refuseMember(RedirectAttributes attr, @RequestParam(value = "cname") String cname,
			@RequestParam(value = "pid") Long pid) {
		
		Club club = clubService.getClub(cname);
		Registration regi = regiService.getByRegiClubPerson(pid, club.getCid());
		
		regiService.deleteRegistration(regi.getRid());

		attr.addAttribute("cname", cname);
		return "redirect:memberManage";
	}
	
}
