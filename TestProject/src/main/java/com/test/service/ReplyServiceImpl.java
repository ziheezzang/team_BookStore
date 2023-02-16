package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dto.Reply;
import com.test.persistence.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	ReplyRepository replyRepo;
	
	@Override
	public void insertReply(Reply reply) {
		replyRepo.save(reply);
		
	}

	@Override
	public void deleteReply(Reply reply) {
		replyRepo.deleteById(reply.getReseq());
	}

	@Override
	public void updateReply(Reply reply) {
		Reply findReply=replyRepo.findById(reply.getReseq()).get();
		
		findReply.setQna(reply.getQna());
		findReply.setRecontent(reply.getRecontent());
		findReply.setReseq(reply.getReseq());
		findReply.setUser(reply.getUser());
		replyRepo.save(findReply);
	}

	@Override
	public List<Reply> getReplyList() {
		return replyRepo.findAll();
	}

}
