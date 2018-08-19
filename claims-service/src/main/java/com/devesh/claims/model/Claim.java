package com.devesh.claims.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="claim")
public class Claim {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;*/
	
	@Id
	@Column(name="claim_id")
	private Integer claimId;
	
	@OneToMany
	private List<Service> services;

	public Claim() {
		super();
	}

	public Claim(Integer id, Integer claimId, List<Service> services) {
		super();
		//this.id = id;
		this.claimId = claimId;
		this.services = services;
	}

	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

	public Integer getClaimId() {
		return claimId;
	}

	public void setClaimId(Integer claimId) {
		this.claimId = claimId;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}
	
	
}
