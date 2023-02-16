package com.ezen;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.dto.Member;
import com.ezen.dto.Review;
import com.ezen.dto.Role;
import com.ezen.persistance.MemberRepository;
import com.ezen.persistance.ReviewRepositoy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRepositoryTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private ReviewRepositoy reviewRepo;

	//Best review test
	//@Disabled 
	@Test
	public void testInsert() {
		Member member1 = new Member();
		member1.setUser_id("doolly123");
		member1.setPassword("doolly123");
		member1.setName("둘리");
		member1.setRole(Role.ROLE_MEMBER);
		//member1.setPoint(0);
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setUser_id("downer456");
		member2.setPassword("downer456");
		member2.setName("도우너");
		member2.setRole(Role.ROLE_MEMBER);
		//member2.setPoint(0);
		memberRepo.save(member2);
		
		for (int i = 1; i <= 3; i++) {
			Review review = new Review();
			review.setMember(member1);
			review.setBook_id("궁금한 이야기 why "+i );
			review.setContent(member1.getUser_id() + "님이 "+i+"번째 등록한 리뷰 입니다.");
			review.setRegdate(new Date());
			reviewRepo.save(review);
		}
		
		for (int i = 1; i <= 3; i++) {
			Review review = new Review();
			review.setMember(member2);
			review.setBook_id("해리포터 "+i);
			review.setContent(member2.getUser_id() + "님이 " + i +"번째 등록한 리뷰입니다.");
			review.setRegdate(new Date());
			reviewRepo.save(review);
		}
	}
	
	

}
