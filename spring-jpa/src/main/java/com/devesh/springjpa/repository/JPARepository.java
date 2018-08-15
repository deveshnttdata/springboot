package com.devesh.springjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devesh.springjpa.model.Reservation;


public interface JPARepository  extends JpaRepository<Reservation,Long>{
	
	@Query(name="Reservation.findByRestaurant", nativeQuery = true)
	public Reservation findByRestaurant(Long restaurantId);

}
