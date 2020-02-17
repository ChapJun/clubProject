package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.club.domain.Activity_Board;


public interface Activity_BoardRepository extends JpaRepository<Activity_Board, Long> {

	@Query("select b from Activity_Board b where rownum <= 5 order by b.board_no desc")
	List<Activity_Board> findTop5();
	
	@Query("select b from Activity_Board b where b.board_no=?1")
	Optional<Activity_Board> queryACtGetBoard(Long board_no);
	
	List<Activity_Board> findByTitleContaining(String keyword);

	@Transactional
	@Modifying
	@Query(nativeQuery = true,value="update activity_board a set a.read_cnt=a.read_cnt+1 where a.activity_board_id=?1")
	void queryUpdateCnt(@Param("board_no")Long board_no);
}
