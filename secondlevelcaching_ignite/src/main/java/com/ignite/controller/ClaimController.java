package com.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.model.Claim;
import com.ignite.repo.ClaimRepository;
import com.ignite.service.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	ClaimService claimService;
	
	@Autowired
	ClaimRepository claimRepository;
	
	@RequestMapping("/processed/{claimId}")
	public Claim getClaimById(@PathVariable String claimId) {
		return claimService.getClaimById(claimId);
	}
	
	@RequestMapping("/claims")
	public Claim saveClaimById(@RequestBody Claim claim) {
		return claimRepository.save("key1",claim);
	}
	
	
}
