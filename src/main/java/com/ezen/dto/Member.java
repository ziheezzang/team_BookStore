package com.ezen.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString(exclude="reviewList")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
	@Id
	@Column(name="MEMBER_ID")
	private String user_id;
	
	private String password;
	
	private String name;
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	private int point;
	
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER)
	private List<Review> reviewList = new ArrayList<Review>();
}
