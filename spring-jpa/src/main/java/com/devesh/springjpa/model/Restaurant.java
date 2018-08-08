package com.devesh.springjpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurant")
public class Restaurant implements Serializable{

	/*@Column(name="id")
	private Long id;*/
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="restaurant_id")
	private Integer restaurantId;
	
	
	@Column(name="restaurant_name")
	private String restaurantName;

	
	
	

	public Restaurant() {
		//super();
	}

	public Restaurant(Long id, Integer restaurantId, String restaurantName) {
		super();
		//this.id = id;
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
	}

	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}*/

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

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + "]";
	}

	
	
	
	
}
