package com.ignite.dao;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.ignite.model.Dog;

@RepositoryConfig(cacheName="DogCache")
public interface DogRepository extends IgniteRepository<Dog, Long>{

	List<Dog> getDogByName(String name);
    Dog getDogById (Long id);
}
