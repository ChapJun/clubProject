package com.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping("/")
	public String index() {
//		System.out.println("index 요청입니다.");
		return "index";
	}
	
	@GetMapping("/person")
	public void forPerson() {
//		System.out.println("Person 요청입니다.");
	}
	
	@GetMapping("/accessDenied")
	public void accessDenied() {
	}
}
