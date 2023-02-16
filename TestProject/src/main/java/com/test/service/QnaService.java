package com.test.service;

import org.springframework.data.domain.Page;

import com.test.dto.Qna;

public interface QnaService {

	void insertQna(Qna qna);
	void updateQna(Qna qna);
	void deleteQna(Qna qna);
	Qna getQna(Qna qna);
	Page<Qna> getQnaList(int page);
}
