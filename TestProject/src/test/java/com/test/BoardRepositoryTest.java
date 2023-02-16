	package com.test;


import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.test.dto.Board;
import com.test.dto.Orders;
import com.test.dto.Qna;
import com.test.dto.Member;
import com.test.persistence.BoardRepository;
import com.test.persistence.OrderRepository;
import com.test.persistence.QnaRepository;
import com.test.persistence.UserRepository;


@SpringBootTest 
public class BoardRepositoryTest {

	@Autowired
	private BoardRepository boardRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private QnaRepository qnaRepo;

	@Test
	public void testInsert() {

	

			
		 	for (int i = 1; i <= 12; i++) {
		 	Board board = Board.builder()
		 			.id((long)i)
		 			.author("작성자"+i)
		 			.cnt(0L)
		 			.content("내용"+i)
		 			.image("이미지"+i)
		 			.per_point(0.01)
		 			.price(i*1000)
		 			.publisher("출판사"+i)
		 			.purchase(i)
		 			.quantity(i)
		 			.register_date(new Date())
		 			.title("제목"+i)
		 			.type(i)
		 			.build();
		 			boardRepo.save(board);
		 			
		 	
		 	
		 	Member user = Member.builder()
		 			.user_id((long)i)
		 			.name("name"+i)
		 			.password("password"+i)
		 			.point(i*2)
		 			.role(i*2)
		 			.build();
		 			userRepo.save(user);
		 	
			Orders order = Orders.builder()		
		 			.board(board)
					.member(user)
					.seq(i)
					.indate(new Date())
					.quantity(i)
					.result("1")
					.seq(i)		
					.build();
					orderRepo.save(order);
			
			
				Qna qna = Qna.builder()
					.member(user)
					.seq((long)i)
					.title("제목"+i)
					.indate(new Date())
					.content("내용"+i)
					.genre("교환")
					.build();
				qnaRepo.save(qna);
				}
		}
	}
				

