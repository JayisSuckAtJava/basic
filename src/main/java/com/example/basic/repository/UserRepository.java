package com.example.basic.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.basic.model.User;

public interface UserRepository extends JpaRepository<User, String> {

	User findByUserIdAndUserPw(String id,String pw);
}
