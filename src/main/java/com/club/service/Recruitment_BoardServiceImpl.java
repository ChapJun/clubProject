package com.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Recruitment_Board;
import com.club.persistence.Recruitment_BoardRepository;

@Service
public class Recruitment_BoardServiceImpl implements BoardService {

	@Autowired
	Recruitment_BoardRepository reBoardRepo;
	
	@Override
	public List<Recruitment_Board> getBoardList(Recruitment_Board board) {
		return (List<Recruitment_Board>) reBoardRepo.findAll();
	}
	
	@Override
	public void insertBoard(Recruitment_Board board) {
		
	}
	
	@Override
	public Recruitment_Board getReBoard(Recruitment_Board board) {
		return null;
	}
	
	@Override
	public void updateBoard(Recruitment_Board board) {
		
		
	}
	
	@Override
	public void deleteBoard(Recruitment_Board board) {
		
	}
}
