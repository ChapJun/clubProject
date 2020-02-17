package com.club.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.domain.Activity_Board;
import com.club.domain.Person;
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
		model.addAttribute("actList", actList);
		
		return "index";
	}
	
	@GetMapping("/main")
	public void main(Model model, Principal prin) {
		
		String username = prin.getName();
		Person person = personService.getPerson(username);

		model.addAttribute("person", person);
		
		List<Activity_Board> actList = activityService.getTop5List();
		model.addAttribute("actList", actList);
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
}
