package com.ezen.persistance;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ezen.dto.Review;

public interface ReviewRepositoy extends CrudRepository<Review, Long> {
	Page<Review> findAll(Pageable pageable);
	
	//@Query("SELECT b FROM Review b")
	//Page<Review> getReviewList(Pageable pageable);
}
