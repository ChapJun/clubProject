package com.club.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Activity_Board;
import com.club.persistence.Activity_BoardRepository;

@Service
public class ActivityBoardServiceimpl implements ActivityBoardService {
	
	@Autowired
	private Activity_BoardRepository activity_boardRepo;
	

	@Override
	public List<Activity_Board> getBoardList() {
		return (List<Activity_Board>) activity_boardRepo.findAll();
	}

	@Override
	public void insertBoard(Activity_Board board) {
		activity_boardRepo.save(board);
	}

	@Override
	public Activity_Board getBoard(Activity_Board board) {
		return activity_boardRepo.findById(board.getBoard_no()).get();
	}

	@Override
	public void updateBoard(Activity_Board board) {
		Activity_Board findBoard = activity_boardRepo.findById(board.getBoard_no()).get();
		
		findBoard.setTitle(board.getTitle());
		findBoard.setContent(board.getContent());
		activity_boardRepo.save(findBoard);
	}

	@Override
	public void deleteBoard(Activity_Board board) {
		
		activity_boardRepo.deleteById(board.getBoard_no());
	}

}
