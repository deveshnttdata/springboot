package com.devesh.claims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devesh.claims.dao.ClaimServicesDAO;
import com.devesh.claims.model.Claim;
import com.devesh.claims.model.Summary;
import com.devesh.claims.repository.ClaimRepository;
import com.devesh.claims.repository.SummaryRepository;

@RestController
public class ClaimServiceController {

	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	ClaimServicesDAO clamServiceDao;
	
	@Autowired
	SummaryRepository summaryRepository;
	
	
	@RequestMapping(value="/claim/{claimId}")
	public Claim getClaims(@PathVariable Integer claimId){
		
		
		return claimRepository.findByClaimId(claimId);
	}
	
	@RequestMapping(value="/allsummary")
	public List<Summary> getAllSummaryDetails(){
		
		
		return summaryRepository.findAll();
	}
	
	@RequestMapping(value="/summary")
	public List<Summary> getSummaryDetails(){
		
		
		return clamServiceDao.getSummaryDetails();
	}
	
	
	
	
}
