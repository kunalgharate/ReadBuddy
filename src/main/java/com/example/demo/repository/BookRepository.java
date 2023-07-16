package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Book;
import com.example.demo.model.Category;


@Repository
public interface BookRepository extends MongoRepository<Book,String>{

 List<Book> findByCategoryId(Category category);
 List<Book> findByCategoryId(String categoryId);
}
