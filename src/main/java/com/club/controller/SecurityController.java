package com.club.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.domain.Activity_Board;
import com.club.domain.Club;
import com.club.domain.Person;
import com.club.obj.Writer;
import com.club.service.ActivityBoardService;
import com.club.service.PersonService;

@Controller
public class SecurityController {

	@Autowired
	private PersonService personService;

	@Autowired
	private ActivityBoardService activityService;

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

		return "index";
	}

	@GetMapping("/main")
	public void main(Model model, Principal prin) {

		String username = prin.getName();
		Person person = personService.getPerson(username);

		model.addAttribute("person", person);
		
		List<Club> myClubs = personService.getMyClubs(person.getPerson_id());
		model.addAttribute("myClubs", myClubs);
		
		List<Activity_Board> actList = activityService.getTop5List();
		List<Writer> writerList = new ArrayList<>();

		for (Activity_Board activity_Board : actList) {

			Writer writer = new Writer();
			writer.setAct_Board(activity_Board);
			writer.setPerson(activity_Board.getPerson());
			writerList.add(writer);
		}

		model.addAttribute("writerList", writerList);
	}

	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
}
