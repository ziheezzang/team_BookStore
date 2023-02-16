package com.ezen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ezen.dto.Qna;
import com.ezen.persistance.QnaRepository;

@Service
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	private QnaRepository QnaRepo;
	
	@Override
	public Page<Qna> getQnaList(int page) { //0~5 리뷰 페이지 조회 
		
		Pageable pageable = PageRequest.of(page, 5,Sort.by(Sort.Direction.DESC,"seq")); //page라는 변수를 사용하여 다음 페이지로 넘어가도록 int page 생성
		
		return QnaRepo.findAll(pageable);
	}	
	
	
	//Qna 등록 하기 폼 페이지
	@Override
	public void insertQna(Qna qna) {
		
		QnaRepo.save(qna);

	}
	
	//Qna reply 등록 하기 폼 페이지
		@Override
		public void insertQnaReply(Qna qna) {
			
			QnaRepo.save(qna);

		}
	
	
	
	
	
	
	
	
	
	
	@Override
	public Qna getQna(Qna qna) {
		
		return QnaRepo.findById(qna.getSeq()).get();
	}

	//Qna 수정 페이지 
	@Override
	public void updateQna(Qna qna) {
		
		Qna origQna = QnaRepo.findById(qna.getSeq()).get();
	
		origQna.setContent(qna.getContent());
		
		QnaRepo.save(origQna);
	}

	@Override
	public void deleteQna(Qna Qna) {
		
		QnaRepo.deleteById(Qna.getSeq());

	}



	


}

