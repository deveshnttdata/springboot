package com.devesh.springjpa.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation implements Serializable {

	@Id
	@Column(name = "id")
	private Long id;

	@Column(name = "dt")
	private Timestamp dt;

	@Column(name = "user_id")
	private Long userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;

	@Column(name = "party_size")
	private Integer partySize;

	@Column(name = "capacity")
	private Integer seats;

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDt() {
		return dt;
	}

	public void setDt(Timestamp dt) {
		this.dt = dt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Integer getPartySize() {
		return partySize;
	}

	public void setPartySize(Integer partySize) {
		this.partySize = partySize;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", dt=" + dt + ", userId=" + userId + ", restaurant=" + restaurant
				+ ", partySize=" + partySize + ", seats=" + seats + "]";
	}

	public Reservation(Long id, Timestamp dt, Long userId, Restaurant restaurant, Integer partySize, Integer seats) {
		super();
		this.id = id;
		this.dt = dt;
		this.userId = userId;
		this.restaurant = restaurant;
		this.partySize = partySize;
		this.seats = seats;
	}

	public Reservation() {
		super();
	}

}
