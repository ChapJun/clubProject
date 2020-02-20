package com.club.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.domain.Club;
import com.club.domain.Registration;
import com.club.domain.Schedule;
import com.club.domain.Scheduling;
import com.club.service.ClubService;
import com.club.service.PersonService;
import com.club.service.RegistrationService;
import com.club.service.ScheduleService;

@Controller
public class RegistrationController {

	@Autowired
	private RegistrationService regiService;

	@Autowired
	private ClubService clubService;

	@Autowired
	private ScheduleService scheService;

	@Autowired
	private PersonService personService;

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
		// club person
		// 해당 클럽에 해당하는 스케줄을 모두 불러온다.
		List<Schedule> scheList = scheService.getScheduleAll(club);

		// 스케줄링에서 person과 스케줄리스트이 아이디가 같은 경우 같이 지운다.
		for (Schedule schedule : scheList) {

			Scheduling scheduling = scheService.getSchedulingByScheduleByPerson(schedule,
					personService.findByPersonId(pid));
			
			if(scheduling != null)
				scheService.deleteScheduling(scheduling.getScid());
		}

		attr.addAttribute("cname", cname);
		return "redirect:memberManage";
	}

}
