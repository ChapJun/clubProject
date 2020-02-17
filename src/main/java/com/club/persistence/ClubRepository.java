package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Club;

public interface ClubRepository  extends JpaRepository<Club, Long>{

	@Query("select c from Club c where c.state=1 order by c.cid desc")
	List<Club> findAll();
	
	Page<Club> findAll(Pageable pageable);
	
	Optional<Club> findByCname(String cname);
	
	List<Club> findByCategory(String category);
	
	@Query("SELECT c FROM Club c WHERE c.category=?1 and c.state=1 ORDER BY c.cid DESC")
	List<Club> queryByCategory(String category);
	
	@Query("SELECT c FROM Club c WHERE c.category=?1 and c.state=1 ORDER BY c.cid DESC")
	Page<Club> queryByCategory(String category, Pageable pageable);
}
