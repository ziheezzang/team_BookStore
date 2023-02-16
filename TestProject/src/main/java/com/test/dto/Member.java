package com.test.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.DynamicInsert;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Setter
@ToString
@DynamicInsert @NoArgsConstructor
@SuperBuilder @Getter
public class Member {
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long user_id;
	
	private String password ;//비밀번호
	private String name; //이름
	private int point; //적립금
	private int role; //관리자 이용자 구분



}
