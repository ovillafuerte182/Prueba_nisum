package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public User create (User user) {
		return userRepository.save(user);
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}
	
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}
	
	public List<User> findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
