package com.club.controller;
import java.security.Principal;

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

import com.club.domain.Activity_Board;
import com.club.domain.Person;
import com.club.service.ActivityBoardService;
import com.club.service.PersonService;

@Controller
public class Activity_BoardController {

	Logger logger = LoggerFactory.getLogger(Activity_BoardController.class);
	@Autowired
	ActivityBoardService activityBoardService;
	
	@Autowired
	PersonService personService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, @RequestParam(value="keyword", required = false) String keyword,
			@PageableDefault Pageable pageable) {
		
		Page<Activity_Board> pageList;

		if(keyword == null) {
			pageList = activityBoardService.getBoardPage(pageable);
		}
		else {
			pageList = activityBoardService.searchPosts(pageable, keyword);
		}
		
		
		model.addAttribute("boardList", pageList);
		model.addAttribute("totalPages", pageList.getTotalPages());
		return "getBoardList";
		
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView(Model model, Principal prin) {
		
		String id = prin.getName();
		Person person = personService.getPerson(id);
		
		model.addAttribute("username", person.getName());
		
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Activity_Board board) {
		activityBoardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@RequestParam(value="board_no") Long board_no, Model model,
			Principal prin){
		
		Activity_Board board = activityBoardService.getBoard(board_no);
		logger.info(board.toString());
		activityBoardService.cntPlus(board);
		
		model.addAttribute("Activity_Board", board);
		
		String id = prin.getName();
		Person person = personService.getPerson(id);
		
		model.addAttribute("username", person.getName());
		
		return "getBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Activity_Board board) {
		activityBoardService.updateBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Activity_Board board) {
		activityBoardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	


	
}
