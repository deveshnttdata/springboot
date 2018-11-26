package com.ignite.service;

import org.springframework.stereotype.Service;

import com.ignite.model.Claim;


public interface ClaimService {
	
	public Claim getClaimById(String ClaimId);

}
