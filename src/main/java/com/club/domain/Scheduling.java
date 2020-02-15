package com.club.domain;

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
@Table(name="SCHEDULING")
public class Scheduling {

	@Id
	@GeneratedValue
	private Long scid;
	
	@ManyToOne
	@JoinColumn(name="CLUB_ID")
	private Club club;
	
	@ManyToOne
	@JoinColumn(name="SCHEDULE_ID")
	private Schedule schedule;
}
