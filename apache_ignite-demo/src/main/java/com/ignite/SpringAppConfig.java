package com.ignite;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAppConfig {
	
//	@Bean
//    public Ignite igniteInstance() {
//        IgniteConfiguration cfg = new IgniteConfiguration();
//        // Setting some custom name for the node.
//        cfg.setIgniteInstanceName("springDataNode");
//        // Enabling peer-class loading feature.
//        cfg.setPeerClassLoadingEnabled(false);
//        // Defining and creating a new cache to be used by Ignite Spring Data
//        // repository.
//        CacheConfiguration ccfgDog = new CacheConfiguration("DogCache");
//        CacheConfiguration ccfgBreed = new CacheConfiguration("BreedCache");
//        // Setting SQL schema for the cache.
//        ccfgBreed.setIndexedTypes(Long.class, Breed.class);
//        ccfgDog.setIndexedTypes(Long.class, Dog.class);
// 
//        cfg.setCacheConfiguration(new CacheConfiguration[]{ccfgDog, ccfgBreed});
// 
//        return Ignition.start(cfg);
//    }

}
