package com.ignite.model;

import java.io.Serializable;
import java.sql.Date;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Dog implements Serializable{

	/**
	 * 
	 */
	//private static final long serialVersionUID = -1829019838793980429L;

	@QuerySqlField(index = true)
	private Long id;
	
	@QuerySqlField(index = true)
	private String name;
	
	@QuerySqlField(index = true)
	private Long breedid;
	
	@QuerySqlField(index = true)
	private Date birthdate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBreedid() {
		return breedid;
	}

	public void setBreedid(Long breedid) {
		this.breedid = breedid;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	
	public Dog() {
		super();
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breedid=" + breedid + ", birthdate=" + birthdate + "]";
	}
	
	
}
