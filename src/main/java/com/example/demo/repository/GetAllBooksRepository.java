package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.UserRegistration;

public interface GetAllBooksRepository extends MongoRepository<UserRegistration,String> {
	 

	 
}
