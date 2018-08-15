package com.devesh.springjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devesh.springjpa.model.Reservation;
import com.devesh.springjpa.repository.JPARepository;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private JPARepository reservationJpaRepo;
	
	@Override
	public Reservation searchRestaurantID(Long restID) {
		// TODO Auto-generated method stub
		return reservationJpaRepo.findByRestaurant(restID);
	}

	
}
