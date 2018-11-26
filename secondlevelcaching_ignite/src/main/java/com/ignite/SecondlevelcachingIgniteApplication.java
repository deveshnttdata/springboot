package com.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableIgniteRepositories
public class SecondlevelcachingIgniteApplication {

	@Bean
    public Ignite igniteInstance() {
        IgniteConfiguration cfg = new IgniteConfiguration();
        // Setting some custom name for the node.
        cfg.setIgniteInstanceName("springDataNode");
        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(false);
        // Defining and creating a new cache to be used by Ignite Spring Data
        // repository.
        
        
        
        //CacheConfiguration<Long, Dog> ccfgDog = new CacheConfiguration<>("DogCache");
        //CacheConfiguration<Long, Breed> ccfgBreed = new CacheConfiguration<>("BreedCache");
        // Setting SQL schema for the cache.
        //ccfgBreed.setIndexedTypes(Long.class, Breed.class);
        //ccfgDog.setIndexedTypes(Long.class, Dog.class);
 
        //cfg.setCacheConfiguration(ccfgDog, ccfgBreed);
 
        return Ignition.start(cfg);
    }
	
	@Bean
	public EhCacheCacheManager cacheManager(){
		EhCacheCacheManager cacheManager = new EhCacheCacheManager();
		cacheManager.setCacheManager(ehCacheManager().getObject());
		return cacheManager;
		
	}
	
	@Bean
	public EhCacheManagerFactoryBean ehCacheManager() {
		return new EhCacheManagerFactoryBean();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SecondlevelcachingIgniteApplication.class, args);
	}
}
