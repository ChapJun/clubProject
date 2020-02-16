package com.club.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.club.domain.Person;

public class SecurityUser extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SecurityUser(Person person) {
		super(person.getId(), "{noop}"+person.getPw(),
				AuthorityUtils.createAuthorityList(person.getRole().toString()));
	}
}
