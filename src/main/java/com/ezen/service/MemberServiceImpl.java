package com.ezen.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ezen.dto.Member;
import com.ezen.persistance.MemberRepository;



@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository memberRepo;
	
	@Override
	public Member getMember(Member member) {
		// (1) id로 회원 검색
		Optional<Member> user = memberRepo.findById(member.getUser_id());
		
		// (2) 회원이 존재하는지 확인
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}

}
