package com.ezen.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long rseq;
	
//	private String title;
	
//	private String content;
	
	private String reply;
	
	@Column(updatable=false)
	private String genre;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date regdate = new Date();
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID",nullable=false, updatable=false)
	private Member member;
	
	@ManyToOne
	@JoinColumn(name="seq",nullable=false, updatable=false)
	private Qna qna;
}
