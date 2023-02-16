package com.ezen;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ezen.dto.Member;
import com.ezen.dto.Qna;
import com.ezen.dto.Role;
import com.ezen.persistance.MemberRepository;
import com.ezen.persistance.QnaRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class QnaRepositoryTest {
	@Autowired
	private MemberRepository memberRepo;
	
	@Autowired
	private QnaRepository qnaRepo;

	//Best qna test
	//@Disabled 
	@Test
	public void testInsert2() {
		Member member3 = new Member();
		member3.setUser_id("coke123");
		member3.setPassword("coke123");
		member3.setName("냥냥냥");
		member3.setRole(Role.ROLE_MEMBER);
		//member1.setPoint(0);
		memberRepo.save(member3);
		
		Member member4 = new Member();
		member4.setUser_id("cider456");
		member4.setPassword("cider456");
		member4.setName("응아");
		member4.setRole(Role.ROLE_MEMBER);
		//member2.setPoint(0);
		memberRepo.save(member4);
		
		for (int i = 1; i <= 2; i++) {
			Qna qna = new Qna();
			qna.setMember(member3);
			qna.setTitle("배송문의 드립니다. "+i );
			qna.setGenre("배송");
			qna.setContent("언제 배송 올까요?" +i);
			qna.setRegdate(new Date());
			qnaRepo.save(qna);
		}
		
		for (int i = 1; i <= 2; i++) {
			Qna qna = new Qna();
			qna.setMember(member4);
			qna.setTitle("환불 문의 드립니다. "+i );
			qna.setGenre("환불");
			qna.setContent("환불 가능할까요?" +i);
			qna.setRegdate(new Date());
			qnaRepo.save(qna);
		}
	}
	
	

}
