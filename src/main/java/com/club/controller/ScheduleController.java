package com.club.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.club.domain.Club;
import com.club.domain.Schedule;
import com.club.service.ClubService;
import com.club.service.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	private ClubService clubService;

	@Autowired
	private ScheduleService scheService;

	Logger logger = LoggerFactory.getLogger(ScheduleController.class);

	@GetMapping("/scheduleManage")
	public void scheduleManage(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);
		List<Schedule> scList = scheService.getScheduleList(club);
		model.addAttribute("scList", scList);

	}

	@GetMapping("/deleteSchedule")
	public String deleteSchedule(Model model, @RequestParam(value = "cname") String cname,
			@RequestParam(value = "scid") Long scid, RedirectAttributes attr) {

		scheService.deleteSchedule(scid);
		
		attr.addAttribute("cname", cname);
		
		return "redirect:scheduleManage";
	}

	@GetMapping("/insertSchedule")
	public String insertScheduleView(Model model, @RequestParam(value = "cname") String cname) {

		Club club = clubService.getClub(cname);
		model.addAttribute("club", club);

		return "insertSchedule";
	}

	@PostMapping("/insertSchedule")
	public String insertSchedule(Schedule schedule, RedirectAttributes attr) {

		String from = schedule.getSdate();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		try {
			Date wdate = transFormat.parse(from);
			schedule.setWdate(wdate);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Club club = clubService.getClub(schedule.getCname());
		schedule.setClub(club);

//		logger.info(schedule.toString());

		attr.addAttribute("cname", schedule.getCname());

		scheService.insertSchedule(schedule);
		return "redirect:scheduleManage";
	}

}
