
package com.club.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.club.config.SecurityUser;
import com.club.domain.Club;
import com.club.domain.Person;
import com.club.persistence.PersonRepository;

@Service
public class PersonService implements UserDetailsService {

	@Autowired
	private PersonRepository perRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Person> optional = perRepo.findById(username);
		if(!optional.isPresent()) {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		} else {
			Person person = optional.get();
			return new SecurityUser(person);
		}
	}

	public Person getPerson(String id) {
		
		Optional<Person> optional = perRepo.findById(id);
		Person person = optional.get();
		
		return person;
	}
	
	public Person findByPersonId(Long person_id) {
		
		Optional<Person> person = perRepo.findById(person_id);
		Person per = person.get();
		
		return per;
	}
	
	public List<Club> getMyClubs(Long person_id) {
		return perRepo.findMyClubs(person_id);
	}


}
