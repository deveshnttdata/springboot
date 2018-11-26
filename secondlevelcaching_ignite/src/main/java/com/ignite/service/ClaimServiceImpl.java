package com.ignite.service;

import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignite.model.Claim;
import com.ignite.repo.ClaimRepository;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.statistics.StatisticsGateway;

@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimRepository claimRepository;
	
	@Autowired
	CacheManager cacheManager;
	
	@Override
	public Claim getClaimById(String claimId) {
		// TODO Auto-generated method stub
		
		
		Claim claim = claimRepository.findOne(claimId);
		
		StatisticsGateway stats = cacheManager.getCache("instruments").getStatistics();
		
//		System.out.println("Fetch Count="
//				+ stats.getEntityFetchCount());
//		System.out.println("Second Level Hit Count="
//				+ stats.getSecondLevelCacheHitCount());
//		System.out
//				.println("Second Level Miss Count="
//						+ stats.getSecondLevelCacheMissCount());
		
		System.out.println("Fetch Count="
				+ stats.cachePutCount());
		System.out.println("Second Level Hit Count="
				+ stats.cacheHitCount());
		System.out
				.println("Second Level Miss Count="
						+ stats.cacheMissCount());
				
		
		
		return claim;
		
		
	}

}
