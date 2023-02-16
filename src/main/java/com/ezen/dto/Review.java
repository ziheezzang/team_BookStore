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
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long seq;
	
	@Column(updatable=false)
	private String book_id;
	
	private String content;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(updatable=false)
	private Date regdate = new Date();
	
	@ManyToOne
	@JoinColumn(name="MEMBER_ID",nullable=false, updatable=false) //nullable=false는 joinColumn에 필요!
	private Member member;
	
	/*
	public void setMember(Member member) {        //public void setMember(Member member)  //setName //, String content, String book_id
		this.member = member;
		//this.content = content;
		//this.book_id = book_id;
		member.getReviewList().add(this);
	}*/
	
	
	@Column(updatable=false)
	private Long cnt=0L;


}
