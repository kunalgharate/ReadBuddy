package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.UserRegistration;

public interface UserRepository extends MongoRepository<UserRegistration,String> {

	Optional<UserRegistration> findUserByEmail(String email);
	void deleteUserBySmbuserId(String userId);
}
