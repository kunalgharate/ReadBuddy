package com.example.demo.model;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Book")
public class Book {
    @Id
    private String id;
    private int noOfTag = 1;
    private String bookName;
    private String bookDescription;
    private long bookLength;
    private String bookLang;
    private String bookPublisher;
    private String bookGenre;
    private String bookAuthor;
    private String bookType;
    private String ebookLink;
    private String bookAudioLink;
    private String categoryId;
    @DBRef
    private Category category;
    private List tags;

}
