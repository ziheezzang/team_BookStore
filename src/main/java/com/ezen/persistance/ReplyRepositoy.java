package com.ezen.persistance;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ezen.dto.Reply;

public interface ReplyRepositoy extends JpaRepository<Reply, Long> {
	Page<Reply> findAll(Pageable pageable);
	
	@Query(value="SELECT * FROM Reply WHERE seq=?1", nativeQuery = true)
	List<Reply> findByQnaSeq(long seq);
}
