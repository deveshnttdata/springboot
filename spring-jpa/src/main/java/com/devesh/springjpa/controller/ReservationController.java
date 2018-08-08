package com.devesh.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.springjpa.model.Reservation;
import com.devesh.springjpa.service.ReservationService;

@RestController
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@RequestMapping(value="/reservation/{restId}")
	public Reservation searchRestaurantID(@PathVariable Integer restId){
		return reservationService.searchRestaurantID(restId);
	}

}
