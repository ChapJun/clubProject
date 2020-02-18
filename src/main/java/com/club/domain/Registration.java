package com.club.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="REGISTRATION")
public class Registration {
	
	@Id
	@GeneratedValue
	private Long rid;
	
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@ManyToOne
	@JoinColumn(name="CLUB_ID")
	private Club club;
	
	@Column(columnDefinition = "number(1,0) default 0")
	private boolean enabled;
}
