package com.ezen.persistance;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ezen.dto.Qna;

public interface QnaRepository extends CrudRepository<Qna, Long>{
	Page<Qna> findAll(Pageable pageable);
}
