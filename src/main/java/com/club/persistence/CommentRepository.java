package com.club.persistence;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.domain.Activity_Board;
import com.club.domain.Activity_Board_Comment;

public interface CommentRepository extends JpaRepository<Activity_Board_Comment, Long>{
	
   List<Activity_Board_Comment> findByBoard(Activity_Board board);
}
	