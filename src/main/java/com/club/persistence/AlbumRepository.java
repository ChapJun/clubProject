package com.club.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Album;
import com.club.domain.Club;


public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	@Query("select b from Album b where b.aid=?1")
	Optional<Album> queryACtGetAlbum(Long aid);

	List<Album> findByClub(Club club);
	
	Page<Album> findByClubOrderByWdateDesc(Pageable pageable, Club club);
	
}
