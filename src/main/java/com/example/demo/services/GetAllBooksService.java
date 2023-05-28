package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserRegistration;
import com.example.demo.repository.GetAllBooksRepository;
import com.example.demo.repository.TaskRepository;

@Service
public class GetAllBooksService {
	@Autowired
	private GetAllBooksRepository getAllBooks;
	
	public List<UserRegistration> findAllBooks()
	{
		return getAllBooks.findAll();
	}

}
