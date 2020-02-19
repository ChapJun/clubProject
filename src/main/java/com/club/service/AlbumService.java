package com.club.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.club.domain.Album;
import com.club.domain.Club;

public interface AlbumService {
	
	List<Album> getAlbumList(Album album);

	void insertAlbum(Album album);

	Album getAlbum(Long aid);

	void updateAlbum(Album board);

	void deleteAlbum(Album board);

	List<Album> getAlbumListByClub(Club club);
	
	Page<Album> getAlbumPageByClub(Pageable pageable, Club club);

}