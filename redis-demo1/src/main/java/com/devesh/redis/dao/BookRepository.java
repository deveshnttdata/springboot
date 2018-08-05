package com.devesh.redis.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.redis.model.Book;

public interface BookRepository extends JpaRepository<Book, String>{
	
	Book findByTitle(String title);
	//Book findById(String id);
    //void delete(String title);

}
