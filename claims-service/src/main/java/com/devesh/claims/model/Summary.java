package com.devesh.claims.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="summary")
public class Summary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="member_id")
	private Integer memberId;
	
	@Column(name="subscriber_id")
	private Integer subscriberId;
	
	@Column(name="accum_id")
	private String accumId;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;
	
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name="end_date")
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(Integer subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getAccumId() {
		return accumId;
	}

	public void setAccumId(String accumId) {
		this.accumId = accumId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
