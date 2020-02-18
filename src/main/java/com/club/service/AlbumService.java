package com.club.service;

import java.util.List;

import com.club.domain.Album;

public interface AlbumService {
	
	List<Album> getAlbumList(Album album);

	void insertAlbum(Album album);

	Album getAlbum(Long aid);

	void updateAlbum(Album board);

	void deleteAlbum(Album board);



}