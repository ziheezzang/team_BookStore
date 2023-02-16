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
@DynamicInsert 
@NoArgsConstructor
@SuperBuilder @Getter
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long seq; //주문테이블 아이디
	
	private int quantity; //주문 수량
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date indate; //주문날짜
	
	private String result; //구매 처리, 교환, 환불, 미처리 4가지


	@ManyToOne
	@JoinColumn(name="id", updatable=false)
	public Board board;

	public void setBoard(Board board) {
		this.board=board;
	}
	
	@ManyToOne
	@JoinColumn(name="user_id", updatable=false)
	public Member member;
	
	public void setUser(Member member) {
		this.member=member;
	}
	
	public void setIndate(Date date) {
		indate = new Date();
		
	}
	
	
}
