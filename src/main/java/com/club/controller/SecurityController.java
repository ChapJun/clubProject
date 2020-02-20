package com.club.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.domain.Activity_Board;
import com.club.domain.Club;
import com.club.domain.Person;
import com.club.domain.Registration;
import com.club.domain.Schedule;
import com.club.obj.Writer;
import com.club.service.ActivityBoardService;
import com.club.service.ClubService;
import com.club.service.PersonService;
import com.club.service.ScheduleService;

@Controller
public class SecurityController {

	@Autowired
	private PersonService personService;

	@Autowired
	private ActivityBoardService activityService;

	@Autowired
	private ClubService clubService;

	@Autowired
	private ScheduleService scheService;

	Logger logger = LoggerFactory.getLogger(SecurityController.class);

	@GetMapping("/")
	public String index(Model model) {
//		System.out.println("index 요청입니다.");
		List<Activity_Board> actList = activityService.getTop5List();
		List<Writer> writerList = new ArrayList<>();

		for (Activity_Board activity_Board : actList) {

			Writer writer = new Writer();
			writer.setAct_Board(activity_Board);
			writer.setPerson(activity_Board.getPerson());
			writerList.add(writer);
		}

		model.addAttribute("writerList", writerList);

		Long maxcid = clubService.getClubIdMaxCount();

		Club maxClub = clubService.getClubById(maxcid);
		model.addAttribute("maxClub", maxClub);

		return "index";
	}

	@GetMapping("/main")
	public void main(Model model, Principal prin) {

		String username = prin.getName();
		Person person = personService.getPerson(username);

		model.addAttribute("person", person);

		List<Registration> myRegi = personService.getMyRegistration(person.getPerson_id());

//		List<Club> myClubs = personService.getMyClubs(person.getPerson_id());
		model.addAttribute("myRegi", myRegi);

		List<Activity_Board> actList = activityService.getTop5List();
		List<Writer> writerList = new ArrayList<>();

		for (Activity_Board activity_Board : actList) {

			Writer writer = new Writer();
			writer.setAct_Board(activity_Board);
			writer.setPerson(activity_Board.getPerson());
			writerList.add(writer);
		}

		model.addAttribute("writerList", writerList);

		Long maxcid = clubService.getClubIdMaxCount();

		Club maxClub = clubService.getClubById(maxcid);
//		logger.info(maxClub.toString());
		model.addAttribute("maxClub", maxClub);

		List<Schedule> sList = scheService.getByPersonScheduleList(person);
		model.addAttribute("sList", sList);
		model.addAttribute("upEvent", sList.get(0));

	}

	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
}
