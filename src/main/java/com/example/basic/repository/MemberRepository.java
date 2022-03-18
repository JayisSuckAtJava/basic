package com.example.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	
	Member findByUserIdAndUserPassword(String userId,String userPassword);

}
