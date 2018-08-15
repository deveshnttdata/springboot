package com.devesh.ticketbooking.service;

import java.util.List;

public interface TicketService{
	
	public List<Integer> updateMovieByMovieName(String movieName, List<Integer> seats);
	public List<Integer> getSeatsFromCache(String movieName);

}
