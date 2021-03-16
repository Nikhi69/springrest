package com.nikhil.truyum.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nikhil.truyum.entity.User;
import com.nikhil.truyum.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public User get(int id) {
		return userRepository.findById(id).get();
	}
	@Transactional
	public User findByName(String name) {
		return userRepository.findByUsername(name);
	}
	@Transactional
	public void save(User user) {
		userRepository.save(user);
	}
}
