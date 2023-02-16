package com.test.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.dto.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	@Query(value="SELECT r FROM qna r", nativeQuery = true)
	Page<Reply> getReplyList(Pageable page);
}
