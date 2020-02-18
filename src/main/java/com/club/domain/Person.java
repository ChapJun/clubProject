package com.club.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name="PERSON")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private Long person_id;
	
	@Column(unique=true, columnDefinition = "varchar2(50 BYTE)", nullable=false)
	private String id;
	@Column(columnDefinition = "varchar2(100 BYTE)", nullable=false)
	private String pw;
	@Column(columnDefinition = "varchar2(50 BYTE)", nullable=false)
	private String name;
	@Column(insertable=false, columnDefinition = "varchar2(50 BYTE) default '010'")
	private String tel;
	@Column(insertable=false, columnDefinition = "varchar2(50 BYTE) default '무소속'")
	private String belong;
	@Column(insertable=false, columnDefinition = "varchar2(200 BYTE) default 'img/Default-Profile.png'")
	private String person_img;
	@Column(insertable=false, columnDefinition = "number default 1")
	private Long authority;
	@Column(columnDefinition = "varchar2(200 BYTE)")
	private String intro;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
	
}
