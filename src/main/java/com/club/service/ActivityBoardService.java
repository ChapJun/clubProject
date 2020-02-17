package com.club.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.club.domain.Activity_Board;

public interface ActivityBoardService {

	List<Activity_Board> getTop5List();
	
	List<Activity_Board> getBoardList();

	void insertBoard(Activity_Board board);

	Activity_Board getBoard(Long board_no);

	void updateBoard(Activity_Board board);

	void deleteBoard(Activity_Board board);

	List<Activity_Board> searchPosts(String keyword);
	
	Page<Activity_Board> searchPosts(Pageable pageable, String keyword);
	
	Page<Activity_Board> getBoardPage(org.springframework.data.domain.Pageable pagable);
	
	void cntPlus(Activity_Board board);

}