package com.club.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.club.domain.Album;
import com.club.domain.Club;
import com.club.domain.Person;
import com.club.domain.Registration;
import com.club.domain.Schedule;
import com.club.domain.Scheduling;
import com.club.service.AlbumService;
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

	@Autowired
	private AlbumService albumservice;

	Logger logger = LoggerFactory.getLogger(ClubController.class);

	@GetMapping("/clubManage")
	public void clubManage(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);
	}

	@GetMapping("/clubMain")
	public void clubMain(Model model, @RequestParam(value = "cname") String cname, Principal prin,
			@PageableDefault Pageable pageable) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

		// 이 클럽의 스케줄
		List<Schedule> scList = scheService.getScheduleList(club);
		model.addAttribute("schedule", scList);

		List<Registration> regList = regiService.findRegiByClub(club.getCid());

		List<Person> memberList = new ArrayList<>();
		List<Person> capList = new ArrayList<>();

		String username = prin.getName();
		Person per;

		if (username != null)
			per = personService.getPerson(username);
		else
			per = personService.getPerson("jun"); // null 처리

		for (Registration registration : regList) {

			Person person = personService.findByPersonId(registration.getPerson().getPerson_id());

			if (person.getPerson_id() == per.getPerson_id()) {
				model.addAttribute("regi", registration);
			}

			if (registration.getEnabled() == 1) {
				memberList.add(person);
			} else if (registration.getEnabled() == 2) { // 2
				capList.add(person);
			} else { // 0

			}

		}

		model.addAttribute("members", memberList);
		model.addAttribute("caps", capList);

		Page<Album> albumList = albumservice.getAlbumPageByClub(pageable, club);
		model.addAttribute("albumList", albumList);
		model.addAttribute("totalPages", albumList.getTotalPages());

		List<Long> dulingIdList = new ArrayList<>();

		for (Schedule sche : scList) {

			Scheduling ss = scheService.getSchedulingByScheduleByPerson(sche, per);
			if (ss != null) {

				long scid = ss.getSchedule().getScid();
//				logger.info(String.valueOf(scid));
				dulingIdList.add(scid);
			}

		}

//		logger.info(String.valueOf(dulingIdList.size()));
		model.addAttribute("dulingIdList", dulingIdList);
	}

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
		regi.setEnabled(0L);

		regiService.insertRegistraion(regi);

		return "redirect:/clubIntro";
	}
}
