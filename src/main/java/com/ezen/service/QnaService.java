package com.ezen.service;

import org.springframework.data.domain.Page;

import com.ezen.dto.Qna;

public interface QnaService {
	Page<Qna> getQnaList(int page); //페이징 처리가 된 리뷰 목록! page를 변수로 칭해줘야 다음 페이지의 화면이 출력된다.
	
	Qna getQna(Qna qna); //qna 상세 보기 페이지
	
	void insertQna(Qna qna);

	void updateQna(Qna qna);
	
	void deleteQna(Qna qna);

	void insertQnaReply(Qna qna);


}
