package com.devesh.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        System.out.println("Hello,, Chai pee lo");
        System.out.println(insertedBook.hashCode());
        return insertedBook;
    }
    
    @RequestMapping(value = "/book/get/{title}", method = RequestMethod.GET)
    @Cacheable(value = "book", key = "#title")
    public Book findGetOne(@PathVariable String title) 
    {
        Book insertedBook = repository.getOne(title);
        System.out.println("Hello Devesh,, Chai pee lo");
        return insertedBook;
    }
    
    @RequestMapping(value = "/book/id/{id}", method = RequestMethod.GET)
    @Cacheable(value = "book", key = "#id")
    public Book findBookById(@PathVariable String id) 
    {
        Book insertedBook = repository.findById(id).get();
        System.out.println("Hello Manu,, Chai pee lo");
        return insertedBook;
    }
    
    
    @PutMapping("/update")
    @CachePut(value = "book", key="#book.id")
    //@Cacheable(value = "book", key="#a0")
    public Book updatePersonByID(@RequestBody Book book) {
    //save is not required since @CachePut takes care to put in cache, save is use for DB.
      //repository.save(book);
      return book;
    }
	
	
}
