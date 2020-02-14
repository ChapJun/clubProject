package com.club.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.domain.Recruitment_board;

@Repository
public interface Recruitment_boardRepository extends JpaRepository<Recruitment_board, Long> {

}
