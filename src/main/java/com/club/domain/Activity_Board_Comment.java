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
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="ACTIVITY_BOARD_COMMENT")

@Getter
@Setter
@ToString
public class Activity_Board_Comment {

	@Id
	@GeneratedValue
	private Long cmt_no;
	@Column(columnDefinition = "varchar2(500 BYTE)")
	private String content;
	
	@Column(columnDefinition = "varchar2(50 BYTE)")
	private String cmt_name;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable=false, updatable=false, columnDefinition = "date default sysdate")
	private Date cmt_regdate;
	
	@ManyToOne
	@JoinColumn(name="ACTIVITY_BOARD_ID")
	private Activity_Board board;
	
	@Transient
	private Long board_no;
	
}
