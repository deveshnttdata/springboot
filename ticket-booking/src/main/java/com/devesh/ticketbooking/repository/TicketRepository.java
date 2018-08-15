package com.devesh.ticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.ticketbooking.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer>{

}
