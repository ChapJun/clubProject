package com.club.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.club.domain.Recruitment_board;
import com.club.service.BoardService;

@RestController
public class Recruitment_boardController {

	@Autowired
	BoardService boardService;
	
	Logger logger = LoggerFactory.getLogger(Recruitment_boardController.class);
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^");
		return "hello";
		// 리턴 타입을 String으로하고 hello하면 hello.html로 이동.
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model, Recruitment_board board) {
		
		List<Recruitment_board> boardList = boardService.getBoardList(board);
		
		model.addAttribute("reboardList", boardList);
		return "getBoardList";
	}
}
