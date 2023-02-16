package com.test.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.test.dto.Member;

public interface UserRepository extends JpaRepository<Member,Long>{
	@Query(value="SELECT u FROM users u", nativeQuery=true)
	Page<Member> getUserList(Pageable page);

}
