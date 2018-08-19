package com.devesh.claims.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.claims.model.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Integer>{
	
	public Claim findByClaimId(Integer claimId);

}
