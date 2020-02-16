package com.club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.club.service.ClubService;

@Controller
public class ClubController {

	@Autowired
	private ClubService clubSerivce;
	
}
