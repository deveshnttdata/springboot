package com.devesh.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.redis.dao.BookRepository;
import com.devesh.redis.model.Book;

@RestController
public class RedisController {

	@Autowired
    BookRepository repository;
    
	
	//@Autowired
    //MongoTemplate mongoTemplate;
   
    
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book saveBook(Book book) 
    {
        return repository.save(book);
    }
    @RequestMapping(value = "/book/{title}", method = RequestMethod.GET)
    @Cacheable(value = "book", key = "#title")
    public Book findBookByTitle(@PathVariable String title) 
    {
        Book insertedBook = repository.findByTitle(title);
        return insertedBook;
    }
    
   /* @CachePut(value = "book", key = "#book.id")
    @PutMapping("/update")
    public User updatePersonByID(@RequestBody User user) {
      userRepository.save(user);
      return user;
    }*/
	
	
}
