package com.devesh.ticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.ticketbooking.model.Movie;
import com.devesh.ticketbooking.repository.MovieRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/movie")
@Api(value = "movie", description = "Rest API for movie operations", tags = "Movie API")
public class TicketController {

	@Autowired
	MovieRepository movieRepository;

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
}
