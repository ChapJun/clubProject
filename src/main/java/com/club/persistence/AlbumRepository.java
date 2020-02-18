package com.club.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Album;


public interface AlbumRepository extends JpaRepository<Album, Long> {
	
	@Query("select b from Album b where b.aid=?1")
	Optional<Album> queryACtGetAlbum(Long aid);

}
