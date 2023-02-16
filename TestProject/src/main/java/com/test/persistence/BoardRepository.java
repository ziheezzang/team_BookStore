package com.test.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.dto.Board;
public interface BoardRepository extends JpaRepository<Board, Long>{
	@Query(value="SELECT b FROM Board b", nativeQuery =true)
	Page<Board> getBoardList(Pageable page);	
	
	
	
}

