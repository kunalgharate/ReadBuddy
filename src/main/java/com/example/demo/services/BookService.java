package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.BookNotFoundException;
import com.example.demo.CategoryNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
import com.example.demo.model.UserRegistration;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	@Autowired
	CategoryRepository categoryRepository;
public void addBook(Book book)
{  
	
	Category category = categoryRepository.findById(book.getCategoryId()).orElse(null);
	book.setCategory(category);
	bookRepository.save(book);
}

public List<Book> findAllBooks()
{
	return bookRepository.findAll();
	//.orElseThrow(() -> new BookNotFoundException("Book not found"));
}

public Book getBookById(String bookid)
{
	return bookRepository.findById(bookid).orElseThrow(() -> new BookNotFoundException("Book not found of this "+bookid));
}

public List<Book> getBookByCategory(String categoryId)
{
	// Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new BookNotFoundException("Book not found of this category"));
	 //System.out.println("category found in getBookByCategory  Method "+category);
	 List<Book> books = bookRepository.findByCategoryId(categoryId);
	  System.out.println(books);
	 if(!books.isEmpty())
	 {
		return books; 
	 }
	 else {
		 throw  new BookNotFoundException("Book not found of this category "); 
	 }
}

}
