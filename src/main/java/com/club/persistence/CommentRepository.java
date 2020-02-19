package com.club.persistence;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.club.domain.Activity_Board;
import com.club.domain.Activity_Board_Comment;

public interface CommentRepository extends JpaRepository<Activity_Board_Comment, Long>{
	
   
	
}
