package com.club.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Registration;
import com.club.persistence.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository regRepo;

	Logger logger = LoggerFactory.getLogger(RegistrationService.class);

	public void insertRegistraion(Registration regi) {

		Optional<Registration> registration = regRepo.findByRegiPerson(regi.getPerson().getPerson_id(), regi.getClub().getCid());

		if (registration.isPresent()) {
			return;
		} else {
			regRepo.save(regi);
		}

	}
	
	public List<Registration> findRegiByClub(Long club_id) {
		return regRepo.findRegiByClub(club_id);
	}
	
}
