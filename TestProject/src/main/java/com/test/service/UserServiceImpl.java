package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.dto.Member;
import com.test.persistence.UserRepository;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public Page<Member> getUserList(int page) {
		return userRepo.findAll(PageRequest.of(page, 10,Sort.Direction.DESC,"name"));
	}

	@Override
	public Member getUser(Member user) {
		
		return userRepo.findById(user.getUser_id()).get();
	}

	@Override
	public void deleteUser(Member user) {
		userRepo.deleteById(user.getUser_id());
	}

	@Override
	public void updateUser(Member user) {
		Member findUser = userRepo.findById(user.getUser_id()).get();
		
		findUser.setName(user.getName());
		findUser.setPassword(user.getPassword());
		findUser.setPoint(user.getPoint());
		findUser.setRole(user.getRole());
		
		userRepo.save(user);
		}

}
