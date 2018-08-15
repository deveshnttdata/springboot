package com.devesh.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.ticketbooking.model.Movie;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

}
