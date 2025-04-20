package com.example.demo.services;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.BookNotFoundException;
import com.example.demo.CategoryNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.Category;
//import com.example.demo.model.UserRegistration;
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

public Book deleteBookById(String bookid)
{
	
	Book book=bookRepository.findById(bookid).orElseThrow(() -> new BookNotFoundException("Book not found of this "+bookid));
	bookRepository.deleteById(bookid);
	return book;
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

 
 
	 public Book updateBookById(String bookId, Book updatedBook) {
		 Book existingBook = bookRepository.findById(bookId).orElse(null);
		 
		 System.out.println("existing book find with given id"+existingBook);
	        if (existingBook != null) {
	              
	        	existingBook.setBookAuthor(updatedBook.getBookAuthor());
	            existingBook.setBookName(updatedBook.getBookName());
	            
	             System.out.println( existingBook.getBookAuthor()   + "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	           
	            bookRepository.save(existingBook);
	            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	                return existingBook;
	            
	        }
	        return null; // Return null if the book with the given ID is not found
	    }
	

	 public Book updateBookFields(String id, Map<String, String> updatedFields) {
	        Optional<Book> optionalBook = bookRepository.findById(id);
	        if (optionalBook.isPresent()) {
	            Book book = optionalBook.get();

	            // Update only the fields present in the request body
	            if (updatedFields.containsKey("bookName")) {
	                book.setBookName(updatedFields.get("bookName"));
	            }
	            if (updatedFields.containsKey("bookDescription")) {
	                book.setBookDescription(updatedFields.get("bookDescription"));
	            }
	            if (updatedFields.containsKey("bookLength")) {
	                long bookLength = Long.parseLong(updatedFields.get("bookLength"));
	                book.setBookLength(bookLength);
	            }
	            if (updatedFields.containsKey("bookLang")) {
	                book.setBookLang(updatedFields.get("bookLang"));
	            }
	            if (updatedFields.containsKey("bookPublisher")) {
	                book.setBookPublisher(updatedFields.get("bookPublisher"));
	            }
	            if (updatedFields.containsKey("bookGenre")) {
	                book.setBookGenre(updatedFields.get("bookGenre"));
	            }
	            if (updatedFields.containsKey("bookAuthor")) {
	                book.setBookAuthor(updatedFields.get("bookAuthor"));
	            }
	            if (updatedFields.containsKey("bookType")) {
	                book.setBookType(updatedFields.get("bookType"));
	            }
	            if (updatedFields.containsKey("ebookLink")) {
	                book.setEbookLink(updatedFields.get("ebookLink"));
	            }
	            if (updatedFields.containsKey("bookAudioLink")) {
	                book.setBookAudioLink(updatedFields.get("bookAudioLink"));
	            }
	            if (updatedFields.containsKey("categoryId")) {
	                book.setCategoryId(updatedFields.get("categoryId"));
	            }
	            // Assuming the tags are a list of strings
	            if (updatedFields.containsKey("tags")) {
	                List<String> tags = Arrays.asList(updatedFields.get("tags").split(","));
	                book.setTags(tags);
	            }

	            return bookRepository.save(book);
	        } else {
	            return null;
	        }
	    }
	 
	 
}


