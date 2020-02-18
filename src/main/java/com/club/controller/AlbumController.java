package com.club.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.club.domain.Album;
import com.club.service.AlbumService;

@Controller
public class AlbumController {
	
	
	@Autowired
	AlbumService albumservice;
	
	
	Logger logger = LoggerFactory.getLogger(AlbumController.class);
	
	@RequestMapping("/getAlbumList")
	public String getAlbumList(Model model, Album album) {
		List<Album> albumList = albumservice.getAlbumList(album);
		
		model.addAttribute("albumList", albumList);
		return "getAlbumList";
	}
	
	@GetMapping("/insertAlbum")
	public String insertAlbumView() {
		return "insertAlbum";
	}
	
	@PostMapping("/insertAlbum")
	public String insertAlbum(Album album,@RequestPart MultipartFile files) throws IllegalStateException, IOException {
		
     
        
        
        albumservice.insertAlbum(album);


		return "redirect:getAlbumList";
		
	}
	
	@GetMapping("/getAlbum")
	public String getAlbum(@RequestParam(value="aid") Long aid, Model model) {
		
		// 리퀘스트 파람으로 아이디 받고 매개변수 정의
		// 그 아이디로 해당 앨범을 쿼리
		// 그 쿼리를 모델에 등록하여 사용
		Album album = albumservice.getAlbum(aid);
		
		model.addAttribute("Album",album);
		return "getAlbum";
	}
	
	@PostMapping("/updateAlbum")
	public String updateAlbum(Album album) {
		albumservice.updateAlbum(album);
		return "redirect:getAlbumList";
	}
	
	@GetMapping("/deleteAlbum")
	public String deleteAlbum(Album album) {
		albumservice.deleteAlbum(album);
		return "forward:getAlbumList";
	}

}
