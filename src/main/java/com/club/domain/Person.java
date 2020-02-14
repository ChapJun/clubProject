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
	private Long pid;
	
	@Column(unique=true, length=50)
	private String id;
	@Column(length=50)
	private String pw;
	@Column(length=50)
	private String name;
	@Column(length=50)
	private String tel;
	@Column(length=50)
	private String belong;
	@Column(nullable = true, columnDefinition = "varchar2(200) default ''")
	private String person_img;
	@Column(nullable = true, columnDefinition = "number default 1")
	private Long authority;
	@Column(nullable = true, columnDefinition = "varchar2(200) default ''")
	private String intro;
	
	
}
