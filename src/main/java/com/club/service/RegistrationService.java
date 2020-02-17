package com.club.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.club.domain.Registration;
import com.club.persistence.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository regRepo;
	
	public void insertRegistraion(Registration regi) {
		regRepo.save(regi);
	}
}
