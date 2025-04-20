package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
//import com.example.demo.model.UserRegistration;
import com.example.demo.services.BookService;


@RestController
@RequestMapping("/book")
public class BookController {	
	
@Autowired
 BookService bookService;
 
@PostMapping("/addbook")
public ResponseEntity<String>addBook(@RequestBody Book book)
{
	 
	bookService.addBook(book);
	String returnmessage="book is addedSuccesfully";
	return new ResponseEntity<>( returnmessage, HttpStatus.CREATED);
	
}

@GetMapping ("/getAllBook")
public ResponseEntity<List<Book>> getBooks() {
	System.out.println("get All method is Called by Shubham");
	List<Book> books = bookService.findAllBooks();
    return new ResponseEntity<>(books,HttpStatus.FOUND);
}
 
@GetMapping ("/getBookById/{bookid}")
public ResponseEntity<Book> getBookById(@PathVariable("bookid") String bookid)
{
	Book book=bookService.getBookById(bookid);
	return  new ResponseEntity<>(book,HttpStatus.FOUND);
	
}

@GetMapping ("/getBookByCategory/{bookCategory}")
public ResponseEntity<List<Book>> getBookByCategory(@PathVariable("bookCategory") String bookCategoryId)
{
	System.out.println("catId"+bookCategoryId+" ");
	List<Book> books=bookService.getBookByCategory(bookCategoryId);
			//.getBookById(bookCategory);
	return  new ResponseEntity<>(books,HttpStatus.FOUND);
	
}

@DeleteMapping ("/deleteBookById/{bookid}")
public ResponseEntity<Book> deleteBookById(@PathVariable("bookid") String bookid)
{
	
	Book book=bookService.deleteBookById(bookid);
	return  new ResponseEntity<>(book,HttpStatus.FOUND);
	
}

@PostMapping("/updateBook/{bookid}")
public ResponseEntity<Book> updateBookById(@PathVariable("bookid") String bookid,@RequestBody Book updatedbook)
{ System.out.println("update query is called ");
                   
 Book book=bookService.updateBookById(bookid,updatedbook);
 
 return new ResponseEntity<Book>(book,HttpStatus.OK);
	
}


@PatchMapping("/updateBook/{id}")
public ResponseEntity<?> updateBookFields(@PathVariable String id, @RequestBody Map<String, String> updatedFields) {
    Book updatedBook = bookService.updateBookFields(id, updatedFields);
    if (updatedBook != null) {
        return ResponseEntity.ok(updatedBook);
    } else {
    	  String message="Book not found with given id to update";
    	  return   new ResponseEntity(message,HttpStatus.NOT_FOUND);
    }
}




}
