package com.test.service;

import org.springframework.data.domain.Page;

import com.test.dto.Member;

public interface UserService {

	Page<Member> getUserList(int page);
	Member getUser(Member user);
	void deleteUser(Member user);
	void updateUser(Member user);
}
