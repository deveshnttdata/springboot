package com.devesh.springjpa.model;

import java.io.Serializable;
import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Reservation")
/*@javax.persistence.SqlResultSetMapping(
	    name = "implicit", entities =
	    @javax.persistence.EntityResult(entityClass = Reservation.class)
	)*/
@NamedNativeQuery(name = "Reservation.findByRestaurantId",
query = "SELECT * FROM RESERVATION REV INNER JOIN RESTAURANT RES ON RES.RESTAURANT_ID=REV.RESTAURANTID WHERE REV.RESTAURANTID=?"
//resultClass=Reservation.class
)
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	private Long Id;
	
	@Column(name="dt")
	private Timestamp dt;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="party_size")
	private Integer partySize;

	@Column(name="restaurant_id")
	private Integer restaurantId;
	
	@OneToOne
	@JoinColumn(name="restaurant")
	private Restaurant restaurant;
	
	
	

	public Reservation() {
		//super();
	}

	public Reservation(Long id, Timestamp dt, Long userId, Integer partySize, Integer restaurantId,
			Restaurant restaurant) {
		super();
		Id = id;
		this.dt = dt;
		this.userId = userId;
		this.partySize = partySize;
		this.restaurantId = restaurantId;
		this.restaurant = restaurant;
	}

	@Override
	public String toString() {
		return "Reservation [Id=" + Id + ", dt=" + dt + ", userId=" + userId + ", partySize=" + partySize
				+ ", restaurantId=" + restaurantId + ", restaurant=" + restaurant + "]";
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public Integer getPartySize() {
		return partySize;
	}

	public void setPartySize(Integer partySize) {
		this.partySize = partySize;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	
	
}
