package com.devesh.ticketbooking.service;

import java.util.List;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{

	
	@CachePut(value = "ticket", key="#movieName")
    public List<Integer> updateMovieByMovieName(String movieName, List<Integer> seats) {
    //save is not required since @CachePut takes care to put in cache, save is use for DB.
      //repository.save(book);
      //List<Integer> listSeatsinCache=getSeatsFromCache("ticket::Tamasha");
     // System.out.println(listSeatsinCache.toString());
		return seats;
    }
    
    @Cacheable(value = "ticket", key="#movieName")
    public List<Integer> getSeatsFromCache(String movieName) 
    {
        //Book insertedBook = repository.findById(id).get();
        //System.out.println("Hello Manu,, Chai pee lo");
        return null;
    }
}
