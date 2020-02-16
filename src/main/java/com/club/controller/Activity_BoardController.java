package com.club.controller;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.club.service.ActivityBoardService;

import com.club.domain.Activity_Board;

@Controller
public class Activity_BoardController {

	@Autowired
	ActivityBoardService activityBoardService;
	
	@GetMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Activity_Board> boardList = activityBoardService.getBoardList();
		
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
	public String getBoard(Activity_Board board, Model model) {
		model.addAttribute("Activity_Board", activityBoardService.getBoard(board));
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
