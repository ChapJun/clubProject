package com.club.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.domain.Recruitment_Board;

@Repository
public interface Recruitment_BoardRepository extends JpaRepository<Recruitment_Board, Long> {

}
