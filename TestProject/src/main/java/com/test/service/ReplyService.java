package com.test.service;

import java.util.List;

import com.test.dto.Reply;

public interface ReplyService {
	
	void insertReply(Reply reply);
	void deleteReply(Reply reply);
	void updateReply(Reply reply);
	List<Reply> getReplyList();
}
