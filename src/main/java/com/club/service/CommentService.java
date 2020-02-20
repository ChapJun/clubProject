package com.club.service;

import java.util.List;

import com.club.domain.Activity_Board;
import com.club.domain.Activity_Board_Comment;

public interface CommentService {
	
	
	List<Activity_Board_Comment> commentList();
	
	void insertComment(Activity_Board_Comment comment);
	
	void deleteComment(Activity_Board_Comment comment);
	
	public List<Activity_Board_Comment> getByActivityBoard(Activity_Board board);
}
