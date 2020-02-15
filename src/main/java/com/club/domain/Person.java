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
@Table(name="PERSON")
public class Person {

	@Id
	@GeneratedValue
	@Column(name = "PERSON_ID")
	private Long pid;
	
	@Column(unique=true, columnDefinition = "varchar2(50 BYTE)", nullable=false)
	private String id;
	@Column(columnDefinition = "varchar2(50 BYTE)", nullable=false)
	private String pw;
	@Column(columnDefinition = "varchar2(50 BYTE)", nullable=false)
	private String name;
	@Column(columnDefinition = "varchar2(50 BYTE)")
	private String tel;
	@Column(columnDefinition = "varchar2(50 BYTE)")
	private String belong;
	@Column(columnDefinition = "varchar2(200 BYTE) default 'img/Default-Profile.png'")
	private String person_img;
	@Column(columnDefinition = "number default 1")
	private Long authority;
	@Column(columnDefinition = "varchar2(200 BYTE)")
	private String intro;
	
}
