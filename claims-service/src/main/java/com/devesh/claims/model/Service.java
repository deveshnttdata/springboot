package com.devesh.claims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service")
public class Service {

	/*@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;*/
	
	@Id
	@Column(name="service_id")
	private Integer serviceId;
	
	@Column(name="service_name")
	private String serviceName;
	
	/*@ManyToOne
	private Claim claim;*/

	/*public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}*/

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	/*public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}*/

	public Service(Integer id, Integer serviceId, String serviceName, Claim claim) {
		super();
		//this.id = id;
		this.serviceId = serviceId;
		this.serviceName = serviceName;
		//this.claim = claim;
	}

	public Service() {
		super();
	}
	
	
	
}
