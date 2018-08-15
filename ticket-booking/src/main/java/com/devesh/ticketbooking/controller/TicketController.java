package com.devesh.ticketbooking.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.ticketbooking.model.Movie;
import com.devesh.ticketbooking.model.Ticket;
import com.devesh.ticketbooking.repository.MovieRepository;
import com.devesh.ticketbooking.repository.TicketRepository;
import com.devesh.ticketbooking.service.TicketService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/movie")
@Api(value = "movie", description = "Rest API for movie operations", tags = "Movie API")
public class TicketController {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	TicketService ticketService;

	@RequestMapping(value="/addmovie", method=RequestMethod.POST)
	@ApiOperation(value = "Add a Movie to the list", response = Movie.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public Movie addMovie(@RequestBody Movie movie) {

		Movie savedMovie = movieRepository.save(movie);
		
		return savedMovie;

	}

	@RequestMapping(value = "/getmovies", method = RequestMethod.GET)
	@ApiOperation(value = "Display list of all movies", response = Movie.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
	public List<Movie> getAllMovies() {

		return movieRepository.findAll();
	}
	
	@RequestMapping(value="/bookTicket/{movieName}/{seats}",method = RequestMethod.GET)
	public List<Integer> bookTicket(@PathVariable String movieName, @PathVariable List<Integer> seats){
		System.out.println("Seats Requestd:"+seats);
		
		
		if(ticketService.getSeatsFromCache(movieName)==null){
			ticketService.updateMovieByMovieName(movieName,seats);
		}else{
			List<Integer> listOfSeats = ticketService.getSeatsFromCache(movieName);
			
			System.out.println("Seats In Cache:"+listOfSeats.toString());
			
			seats.removeAll(listOfSeats);
			
			System.out.println("Availble Seats:"+seats.toString());
		}

		return seats;
	}
	
	
	@PutMapping("/updateSeats/{movieName}/{seats}")
    @CachePut(value = "ticket", key="#movieName")
    public List<Integer> updateMovieByMovieName(@PathVariable String movieName,@PathVariable List<Integer> seats) {
    //save is not required since @CachePut takes care to put in cache, save is use for DB.
      //repository.save(book);
		
		return seats;
    }
    
	@RequestMapping(value = "/{movieName}", method = RequestMethod.GET)
    @Cacheable(value = "ticket", key="#movieName")
    public List<Integer> getSeatsFromCache(@PathVariable String movieName) 
    {
        //Book insertedBook = repository.findById(id).get();
        //System.out.println("Hello Manu,, Chai pee lo");
        return null;
    }
    
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    @Cacheable(value = "movie", key = "#id")
    public Movie findMovieById(@PathVariable Integer id) 
    {
        Movie movie = movieRepository.findById(id).get();
        System.out.println("Hello Manu,, Chai pee lo");
        return movie;
    }
    
    
    @PutMapping("/update")
    @CachePut(value = "tickets", key="#movie.id")
    //@Cacheable(value = "book", key="#a0")
    public Movie updatePersonByID(@RequestBody Movie movie) {
    //save is not required since @CachePut takes care to put in cache, save is use for DB.
      //repository.save(book);
      return movie;
    }
}
