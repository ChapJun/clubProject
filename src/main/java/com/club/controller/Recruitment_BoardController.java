package com.club.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import com.club.domain.Person;
import com.club.domain.Recruitment_Board;
import com.club.persistence.PersonRepository;
import com.club.service.BoardService;

@Controller
public class Recruitment_BoardController {

//	@Autowired
//	BoardService boardService;
//	
//	@Autowired
//	PersonRepository pr;
//
//	Logger logger = LoggerFactory.getLogger(Recruitment_BoardController.class);
//
//	@GetMapping("/getPeople")
//	@ResponseBody
//	public Page<Person> findPeople (Pageable pageable) throws Exception {
//		Page<Person> movie = pr.findAll(pageable);
//        return movie;
//	}
//	
//	@GetMapping("/getPeopleView") 
//	public String getPeopleView() {
//		return "getPeopleView";
//	}
//	
//	@GetMapping("/getBoardList")
//	public String getBoardList(Model model, Recruitment_Board board) {
//
//		List<Recruitment_Board> boardList = boardService.getBoardList(board);
//		model.addAttribute("reboardList", boardList);
//		
//		return "getBoardList";
//	}
//
//	@GetMapping("/hello")
//	public String hello(Model model) {
//		model.addAttribute("greeting", "Hello 타임리프.^^");
//		return "hello";
//		// 리턴 타입을 String으로하고 hello하면 hello.html로 이동.
//	}
}
