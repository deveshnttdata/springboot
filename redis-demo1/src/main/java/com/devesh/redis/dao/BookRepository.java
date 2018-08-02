package com.devesh.redis.dao;

import org.springframework.data.repository.CrudRepository;

import com.devesh.redis.model.Book;

public interface BookRepository extends CrudRepository<Book, String>{
	
	Book findByTitle(String title);
    //void delete(String title);

}
