package com.club.service;

import java.util.List;

import com.club.domain.Recruitment_Board;

public interface BoardService {

	List<Recruitment_Board> getBoardList(Recruitment_Board board);

	void insertBoard(Recruitment_Board board);

	Recruitment_Board getReBoard(Recruitment_Board board);

	void updateBoard(Recruitment_Board board);

	void deleteBoard(Recruitment_Board board);

}