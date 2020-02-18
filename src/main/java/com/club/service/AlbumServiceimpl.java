package com.club.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Album;
import com.club.persistence.AlbumRepository;


@Service
public class AlbumServiceimpl implements AlbumService{
	
	@Autowired
	private AlbumRepository albumRepo;
	
		
	@Override
	public List<Album> getAlbumList(Album album) {
		return (List<Album>) albumRepo.findAll();
	}

	@Override
	public void insertAlbum(Album album) {
		albumRepo.save(album);
	}

	
	@Override
	public void updateAlbum(Album album) {
		Album findAlbum = albumRepo.findById(album.getAid()).get();
		
		findAlbum.setLocation(album.getLocation());
		findAlbum.setAname(album.getAname());
		albumRepo.save(findAlbum);
	}

	@Override
	public void deleteAlbum(Album album) {
		
		albumRepo.deleteById(album.getAid());
	}

	@Override
	public Album getAlbum(Long aid) {
		return albumRepo.queryACtGetAlbum(aid).get();
	}

	
}
