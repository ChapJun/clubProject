package com.club.service;

import java.util.List;

import com.club.domain.Recruitment_board;

public interface BoardService {

	List<Recruitment_board> getBoardList(Recruitment_board board);

	void insertBoard(Recruitment_board board);

	Recruitment_board getReBoard(Recruitment_board board);

	void updateBoard(Recruitment_board board);

	void deleteBoard(Recruitment_board board);

}