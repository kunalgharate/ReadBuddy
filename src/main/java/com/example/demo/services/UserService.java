package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.UserRegistration;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
 
	
	@Service
	public class UserService {

	    @Autowired
	    private UserRepository repository;

	    //CRUD  CREATE , READ , UPDATE , DELETE

 

	    public UserRegistration addUserRegistration(UserRegistration user) {
	        user.setSmbuserId(UUID.randomUUID().toString().split("-")[0]);
	        return repository.save(user);
	    }
 
	}


