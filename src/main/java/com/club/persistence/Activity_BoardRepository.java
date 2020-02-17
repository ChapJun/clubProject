package com.club.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Activity_Board;


public interface Activity_BoardRepository extends JpaRepository<Activity_Board, Long> {

	@Query("select b from Activity_Board b where rownum <= 5 order by b.board_no desc")
	List<Activity_Board> findTop5();
}
