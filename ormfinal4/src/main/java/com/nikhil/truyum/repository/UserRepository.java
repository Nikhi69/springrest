package com.nikhil.truyum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikhil.truyum.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername( String username);
}
