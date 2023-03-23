package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Book;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByPublished(boolean published);
    List<Book> findByTitleContaining(String title);

    List<Book> findByDescriptionContaining(String searchString);
}
