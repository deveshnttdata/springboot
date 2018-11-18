package com.ignite;

import javax.sql.DataSource;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ignite.model.Breed;
import com.ignite.model.Dog;

@SpringBootApplication
@EnableIgniteRepositories
public class ApacheIgniteDemoApplication {//implements CommandLineRunner {

	//@Autowired
	//private static AnnotationConfigApplicationContext appContext;
	/** Ignite Spring Data repository. */
	//@Autowired
    //private static BreedRepository breedrepo;
	//@Autowired
    //private static DogRepository dogrepo;
    
    @Autowired
    DataSource datasource;
    
    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration cfg = new IgniteConfiguration();
        // Setting some custom name for the node.
        cfg.setIgniteInstanceName("springDataNode");
        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(false);
        // Defining and creating a new cache to be used by Ignite Spring Data
        // repository.
        CacheConfiguration<Long, Dog> ccfgDog = new CacheConfiguration<>("DogCache");
        CacheConfiguration<Long, Breed> ccfgBreed = new CacheConfiguration<>("BreedCache");
        // Setting SQL schema for the cache.
        ccfgBreed.setIndexedTypes(Long.class, Breed.class);
        ccfgDog.setIndexedTypes(Long.class, Dog.class);
 
        cfg.setCacheConfiguration(ccfgDog, ccfgBreed);
 
        return Ignition.start(cfg);
    }
    
	public static void main(String[] args) {
		//igniteSpringDataInit();
//		appContext = new AnnotationConfigApplicationContext();
//		appContext.refresh();
//		
//		breedrepo = appContext.getBean(BreedRepository.class);
//		dogrepo = appContext.getBean(DogRepository.class);
		  
		//fill the repository with data and Save
		  
		 
		  
		SpringApplication.run(ApacheIgniteDemoApplication.class, args);
	}
	
//	@Override
//    public void run(String... args) throws Exception {
//
//        String[] beans = appContext.getBeanDefinitionNames();
//        Arrays.sort(beans);
//        for (String bean : beans) {
//            System.out.println(bean);
//        }
//
//    }
	
	/**
     * Initializes Spring Data and Ignite repositories.
     */
//    private static void igniteSpringDataInit() {
//    	appContext = new AnnotationConfigApplicationContext();
//
//        // Explicitly registering Spring configuration.
//    	appContext.register(SpringAppConfig.class);
//
//    	appContext.refresh();
//
//        // Getting a reference to PersonRepository.
//        breedrepo = appContext.getBean(BreedRepository.class);
//        dogrepo = appContext.getBean(DogRepository.class);
//    }
}
