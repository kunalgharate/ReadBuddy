package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.model.UserRegistration;
import com.example.demo.services.TaskService;
import com.example.demo.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserRegistrationController {

	@Autowired
	private UserService service;

	  
	  @PostMapping("/register") //@ResponseStatus(HttpStatus.CREATED) 
	  public UserRegistration createUser(@RequestBody UserRegistration user) {
	  System.out.println("aaaaaaaaaaaaaaaaaa"); 
	  return service.addUserRegistration(user);
	  
	  }

	@PostMapping("/demo")
	public String getName() {
		return "rupesh";
	}

}
