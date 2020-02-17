package com.club.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.club.domain.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long>{

	
}
