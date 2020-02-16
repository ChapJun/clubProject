package com.club.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.domain.Person;
import com.club.service.PersonService;

@Controller
public class SecurityController {

	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public String index() {
//		System.out.println("index 요청입니다.");
		return "index";
	}
	
	@GetMapping("/main")
	public void main(Model model, Principal prin) {
		
		String username = prin.getName();
		Person person = personService.getPerson(username);

		model.addAttribute("person", person);
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
}
