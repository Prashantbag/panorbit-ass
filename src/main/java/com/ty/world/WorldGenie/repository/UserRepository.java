package com.ty.world.WorldGenie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.world.WorldGenie.dto.User;

public interface UserRepository extends JpaRepository<User, String>{

	public Optional<User> findUserByEmail(String email);
}
