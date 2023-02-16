package com.test.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;


import lombok.Builder;
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
public class Board {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private int type;
	private String title;
	private int price;
	private String author;
	private String publisher;// 출판사
	private String content;// 책 내용
	
	@Builder.Default
	@Column(updatable = false)
	public Long cnt = 0L;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date register_date = new Date(); //책 등록 날짜
	
	private String image;// 책 이미지
	private int purchase;// 구매 수
	private int quantity;// 남은 재고
	private double per_point; //적립율

	
	public void setRegister_date(Date date) {
		register_date = new Date();
	}
}


