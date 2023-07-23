package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.JwtHelper;
import com.example.demo.model.Task;
import com.example.demo.model.UserRegistration;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.UserRepository;
 
	@Service
	public class UserService {
        
	    @Autowired
	    private UserRepository repository;
	    
	    @Autowired
	    private JwtHelper jwtHelper;
	    
	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    //CRUD  CREATE , READ , UPDATE , DELETE
	    public UserRegistration addUserRegistration(UserRegistration user) {
	        user.setSmbuserId(UUID.randomUUID().toString().split("-")[0]);
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        return repository.save(user);
	    }

	    public boolean deleteUserByuserId(String authorizationHeader) {
			
			 // Extract JWT token from the Authorization header
           String jwtToken = authorizationHeader.substring(7); // Remove "Bearer " from the header value

           // Extract userId from the token
           String username = jwtHelper.getUsernameFromToken(jwtToken);
            Optional<UserRegistration> users= repository.findUserByEmail(username); // You need to implement this method to get the userId from your data store or database
           // Perform the deletion using a service method
            String userId=users.get().getSmbuserId();
            System.out.println("userId of requested to delete"+userId);
                repository.deleteUserBySmbuserId(userId);			
			return true;
		}
		
 
	}


