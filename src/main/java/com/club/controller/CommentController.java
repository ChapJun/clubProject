package com.club.controller;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.domain.Activity_Board;
import com.club.domain.Activity_Board_Comment;
import com.club.domain.Person;
import com.club.service.ActivityBoardService;
import com.club.service.CommentService;
import com.club.service.PersonService;

@Controller
public class CommentController {

	@Autowired
	CommentService commentservice;

	@Autowired
	PersonService personService;
	
	@Autowired
	private ActivityBoardService actService;

	Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@GetMapping("/CommentList") // 댓글 리스트
	public String commentList(Model model, Activity_Board_Comment comment) {
		List<Activity_Board_Comment> commentList = commentservice.commentList();
		model.addAttribute("commentList", commentList);
		return "getBoard";
	}

//	@GetMapping("/insertComment") //댓글 입력
//	public String insertComment(Activity_Board_Comment comment, Principal prin) {
//		
//		String username = prin.getName();
//		Person person = personService.getPerson(username);
//		
//		comment.setCmt_name(person.getName());
//		commentservice.insertComment(comment);
//		return "forward:getBoard";
//	}
	
	@PostMapping("/insertComment")
	public String insertComment(Activity_Board_Comment comment, Principal prin, RedirectAttributes attr) {
		String username = prin.getName();
		Person person = personService.getPerson(username);
		
		comment.setCmt_name(person.getName());
		comment.setBoard(actService.getBoard(comment.getBoard_no()));
		
		logger.info(comment.toString());
		
		attr.addAttribute("board_no", comment.getBoard_no());
		
		commentservice.insertComment(comment);
		return "redirect:getBoard";
	}

	@GetMapping("/deleteComment") //댓글 삭제
	public String deleteComment(Activity_Board_Comment comment) {
		commentservice.deleteComment(comment);
		return "forward:getBoard";
	}

}
