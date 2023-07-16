package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Category {
    @Id
    private String id;
    private String name;
    
    // Constructors, getters, and setters
}
