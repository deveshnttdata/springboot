package com.ignite.repo;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.ignite.model.Claim;

@RepositoryConfig(cacheName = "instruments")
public interface ClaimRepository extends IgniteRepository<Claim, String>{

}
