package com.club.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.club.domain.Activity_Board;


@Repository
public interface Activity_BoardRepository extends JpaRepository<Activity_Board, Long> {

}
