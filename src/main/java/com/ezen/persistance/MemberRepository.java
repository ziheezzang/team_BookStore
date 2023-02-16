package com.ezen.persistance;

import org.springframework.data.repository.CrudRepository;

import com.ezen.dto.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
