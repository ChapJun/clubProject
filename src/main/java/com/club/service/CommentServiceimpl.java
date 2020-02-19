package com.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Activity_Board;
import com.club.domain.Activity_Board_Comment;
import com.club.persistence.CommentRepository;


@Service
public class CommentServiceimpl implements CommentService {
	
	@Autowired
	private CommentRepository commentrepo;

	@Override
	public List<Activity_Board_Comment> commentList() {
		return (List<Activity_Board_Comment>) commentrepo.findAll();
	}
	
	@Override
	public void insertComment(Activity_Board_Comment comment) {
		commentrepo.save(comment);
	}

	@Override
	public void deleteComment(Activity_Board_Comment comment) {
		commentrepo.deleteById(comment.getCmt_no());
	}

	


}
