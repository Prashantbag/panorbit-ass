package com.ty.world.WorldGenie.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.world.WorldGenie.dto.User;
import com.ty.world.WorldGenie.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findUserByEmail(email); 
	}
	
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	
}
