package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.domain.Club;

public interface ClubRepository  extends JpaRepository<Club, Long>{

	List<Club> findAll();
	Optional<Club> findByCid(Long cid);
}
