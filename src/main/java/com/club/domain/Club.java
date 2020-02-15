package com.club.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="CLUB")
public class Club {
	
	
	@Id
	@GeneratedValue
	@Column(name = "CLUB_ID")
	private Long cid;
	
	@Column(columnDefinition = "varchar2(50 BYTE)", nullable=false)
	private String cname;
	@Column(columnDefinition = "varchar2(200 BYTE) default '1'")
	private String club_img;
	@Column(columnDefinition = "varchar2(200 BYTE)")
	private String intro;
	@Column(columnDefinition = "varchar2(50 BYTE) default '기타'")
	private String category;
	@Column(columnDefinition = "varchar2(2000 BYTE)")
	private String content;
	
	@Column(columnDefinition = "number default 1")
	private Long state;

}
