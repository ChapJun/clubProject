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
@Table(name="ACTIVITY_BOARD")

@Getter
@Setter
@ToString

public class Activity_Board {

	@Id
	@GeneratedValue
	@Column(name = "ACTIVITY_BOARD_ID")
	private Long board_no;
	
	//private String writer_id
	@ManyToOne
	@JoinColumn(name="PERSON_ID")
	private Person person;
	
	@Column(columnDefinition = "varchar2(50 BYTE)")
	private String writer_name;
	@Column(columnDefinition = "varchar2(200 BYTE)")
	private String title;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable=false, updatable=false, columnDefinition = "date default sysdate")
	private Date regdate;
	
	@Column(insertable=false, columnDefinition = "number default 0")
	private Long read_cnt;
	@Column(columnDefinition = "varchar2(2000 BYTE)")
	private String content;
}
