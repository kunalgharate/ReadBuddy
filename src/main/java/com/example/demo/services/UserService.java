package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.model.UserRegistration;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
 
	@Service
	public class UserService {

	    @Autowired
	    private UserRepository repository;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    //CRUD  CREATE , READ , UPDATE , DELETE
	    public UserRegistration addUserRegistration(UserRegistration user) {
	        user.setSmbuserId(UUID.randomUUID().toString().split("-")[0]);
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return repository.save(user);
	    }
 
	}


