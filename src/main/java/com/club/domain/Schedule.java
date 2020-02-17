package com.club.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="SCHEDULE")

@Getter
@Setter
@ToString
public class Schedule {

	@Id
	@GeneratedValue
	@Column(name = "SCHEDULE_ID")
	private Long scid;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(columnDefinition = "date default sysdate")
	private Date wdate;
	@Column(columnDefinition = "varchar2(200 BYTE)")
	private String location;
	@Column(columnDefinition = "varchar2(2000 BYTE)")
	private String content;
	
	@ManyToOne
	@JoinColumn(name="CLUB_ID")
	private Club club;
}
