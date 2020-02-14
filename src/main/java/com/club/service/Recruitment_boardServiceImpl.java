package com.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Recruitment_board;
import com.club.persistence.Recruitment_boardRepository;

@Service
public class Recruitment_boardServiceImpl implements BoardService {

	@Autowired
	Recruitment_boardRepository reBoardRepo;
	
	@Override
	public List<Recruitment_board> getBoardList(Recruitment_board board) {
		return (List<Recruitment_board>) reBoardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Recruitment_board board) {
		
	}
	
	@Override
	public Recruitment_board getReBoard(Recruitment_board board) {
		return null;
	}
	
	@Override
	public void updateBoard(Recruitment_board board) {
		
		
	}
	
	@Override
	public void deleteBoard(Recruitment_board board) {
		
	}
}
