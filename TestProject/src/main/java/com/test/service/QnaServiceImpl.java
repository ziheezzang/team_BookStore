package com.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.test.dto.Qna;
import com.test.persistence.QnaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QnaServiceImpl implements QnaService {
	
	@Autowired
	QnaRepository qnaRepo;
	
	@Override
	public void insertQna(Qna qna) {
		qnaRepo.save(qna);
	}

	@Override
	public void updateQna(Qna qna) {
		Qna findqna = qnaRepo.findById(qna.getSeq()).get();
		
		findqna.setContent(qna.getContent());
		findqna.setTitle(qna.getTitle());
		findqna.setGenre(qna.getGenre());
		qnaRepo.save(findqna);
	}

	@Override
	public void deleteQna(Qna qna) {
		qnaRepo.deleteById(qna.getSeq());
	}		

	@Override
	public Qna getQna(Qna qna) {
		return qnaRepo.findById(qna.getSeq()).get();
	}

	@Override
	public Page<Qna> getQnaList(int page) {
		
		return qnaRepo.findAll(PageRequest.of(page,10,Sort.Direction.DESC,"seq"));
	}
	
	
	
	
	

}
