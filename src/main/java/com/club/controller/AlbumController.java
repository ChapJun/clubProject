package com.club.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.domain.Album;
import com.club.domain.Club;
import com.club.service.AlbumService;
import com.club.service.ClubService;

@Controller
public class AlbumController {

	@Autowired
	private AlbumService albumservice;

	@Autowired
	private ClubService clubService;

	Logger logger = LoggerFactory.getLogger(AlbumController.class);

	@GetMapping("/getAlbumList")
	public void getAlbumList(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

		List<Album> albumList = albumservice.getAlbumListByClub(club);
		model.addAttribute("albumList", albumList);
	}

	@GetMapping("/insertAlbum")
	public String insertAlbumView(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

		return "insertAlbum";
	}

	@PostMapping("/insertAlbum")
	public String insertAlbum(Album album, @RequestParam(value = "cname") String cname,
			@RequestParam(value = "file") MultipartFile file, RedirectAttributes attr)
			throws IllegalStateException, IOException {

		String path = System.getProperty("user.dir");
		path += "\\src\\main\\resources\\static\\img\\";

		if (file.isEmpty()) {
			album.setAname("img/Default-Album.jpg");
		} else {
			logger.info(path + file.getOriginalFilename());

			File f = new File(path + file.getOriginalFilename());

			if (!f.exists())
				file.transferTo(new File(path + file.getOriginalFilename()));

			album.setAname("img/" + file.getOriginalFilename());
		}

		Club club = clubService.getClub(cname);
		attr.addAttribute("cname", cname);

		album.setClub(club);

		albumservice.insertAlbum(album);
		return "redirect:getAlbumList";

	}

	@GetMapping("/getAlbum")
	public String getAlbum(@RequestParam(value = "aid") Long aid, @RequestParam(value = "cname") String cname,
			Model model) {
		Album album = albumservice.getAlbum(aid);
		model.addAttribute("Album", album);

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);
		return "getAlbum";
	}

//	@PostMapping("/updateAlbum")
//	public String updateAlbum(Album album) {
//		albumservice.updateAlbum(album);
//		return "redirect:getAlbumList";
//	}

	@GetMapping("/deleteAlbum")
	public String deleteAlbum(@RequestParam(value = "aid") Long aid, @RequestParam(value = "cname") String cname,
			RedirectAttributes attr) {

		albumservice.deleteAlbum(albumservice.getAlbum(aid));
		attr.addAttribute("cname", cname);
		return "redirect:getAlbumList";
	}

}
