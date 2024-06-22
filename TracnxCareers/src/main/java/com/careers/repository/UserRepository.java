package com.careers.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careers.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByToken(String token);

}
