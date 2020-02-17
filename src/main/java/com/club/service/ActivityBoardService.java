package com.club.service;

import java.util.List;

import com.club.domain.Activity_Board;

public interface ActivityBoardService {

	List<Activity_Board> getTop5List();
	
	List<Activity_Board> getBoardList();

	void insertBoard(Activity_Board board);

	Activity_Board getBoard(Long board_no);

	void updateBoard(Activity_Board board);

	void deleteBoard(Activity_Board board);

	List<Activity_Board> searchPosts(String keyword);

	void cntPlus(Activity_Board board);
}