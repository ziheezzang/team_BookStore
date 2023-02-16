package com.test.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@ToString
@NoArgsConstructor
@DynamicInsert
@SuperBuilder @Getter
public class Qna {
	
	@Id
	@Column(name="seq")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq; //qna 테이블 id
	
	private String title; //제목
	private String content; //질문 내용
	private String genre;
	


	@ManyToOne
	@JoinColumn(name="user_id", updatable=false)
	public Member member;
	
	public void setUser(Member member) {
		this.member=member;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date indate; //답변 날짜
	
	public void setinDate(Date date) {
		indate = new Date();
	}
}
