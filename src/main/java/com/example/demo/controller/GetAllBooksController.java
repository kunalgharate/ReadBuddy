package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.model.UserRegistration;
import com.example.demo.services.GetAllBooksService;
import com.example.demo.services.TaskService;
 
@RestController
@RequestMapping("/book")
public class GetAllBooksController {
	 @Autowired
	    private GetAllBooksService service;

	
	  @GetMapping ("/getAllBook")
	    public List<UserRegistration> getBooks() {
	        return service.findAllBooks();
	    }

}
