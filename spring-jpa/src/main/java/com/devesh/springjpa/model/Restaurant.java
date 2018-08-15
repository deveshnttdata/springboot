package com.devesh.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant{

	/*@Column(name="id")
	private Long id;*/
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;


	@Id
	@Column(name="restaurant_id")
	private Integer restaurantId;
	
	
	@Column(name="restaurant_name")
	private String restaurantName;


	public Integer getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getRestaurantName() {
		return restaurantName;
	}


	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}


	public Restaurant(Integer restaurantId, String restaurantName) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}


	public Restaurant() {
		//super();
	}


	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + "]";
	}

	
	
	
 
	
	
	
}
