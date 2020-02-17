package com.club.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.club.domain.Activity_Board;
import com.club.service.ActivityBoardService;

@Controller
public class Activity_BoardController {

	Logger logger = LoggerFactory.getLogger(Activity_BoardController.class);
	@Autowired
	ActivityBoardService activityBoardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model, @RequestParam(value="keyword", required = false) String keyword) {
		
		List<Activity_Board> boardList;
		

		if(keyword == null) {
			boardList = activityBoardService.getBoardList();
		}
		else {
			boardList = activityBoardService.searchPosts(keyword);
		}
		
		
		model.addAttribute("boardList", boardList);
		return "getBoardList";
		
	}
	
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard")
	public String insertBoard(Activity_Board board) {
		activityBoardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@RequestParam(value="board_no") Long board_no, Model model){
		
		Activity_Board board = activityBoardService.getBoard(board_no);
		logger.info(board.toString());
		activityBoardService.cntPlus(board);
		
		model.addAttribute("Activity_Board", board);
		
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
