package com.ezen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ezen.dto.Reply;
import com.ezen.persistance.ReplyRepositoy;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	public ReplyRepositoy replyRepo;

	@Override
	public Page<Reply> getQna(int page) { //0~5 리뷰 페이지 조회 
		
		Pageable pageable = PageRequest.of(page, 5,Sort.by(Sort.Direction.DESC,"seq")); //page라는 변수를 사용하여 다음 페이지로 넘어가도록 int page 생성
		
		return replyRepo.findAll(pageable);
	}
	
	

	@Override
	public Reply getQna(Reply reply) {
		// TODO Auto-generated method stub
		return replyRepo.findById(reply.getRseq()).get();
	}


	@Override
	public void insertReply(Reply reply) {
		replyRepo.save(reply);
		
	}


	@Override
	public void updateReply(Reply reply) {
		Reply origReply = replyRepo.findById(reply.getRseq()).get();
		
		origReply.setReply(reply.getReply());
		
		replyRepo.save(origReply);
		
	}


	@Override
	public void deleteReply(Reply reply) {
		replyRepo.deleteById(reply.getRseq());
		
	}



	@Override
	public List<Reply> getReplyListByQseq(long rseq) {
		
		return replyRepo.findByQnaSeq(rseq);
	}


	


}

