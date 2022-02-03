package com.api.restapibook.dao;

import com.api.restapibook.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    
}
