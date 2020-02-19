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

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="ALBUM")
public class Album {

	@Id
	@GeneratedValue
	private Long aid;
	
	@Column(columnDefinition = "varchar2(200 BYTE)")
	private String location;
	@Column(insertable=false, columnDefinition = "number default 0")
	private Long good;
	@Column(columnDefinition = "varchar2(200 BYTE) default 'img/Default-Album.jpg'")
	private String aname;
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(insertable=false, updatable=false, columnDefinition = "date default sysdate")
	private Date wdate;
	
	@ManyToOne
	@JoinColumn(name="CLUB_ID")
	private Club club;
	
	@Transient
	private MultipartFile file;
}
