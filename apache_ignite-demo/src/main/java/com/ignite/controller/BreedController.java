package com.ignite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ignite.dao.BreedRepository;
import com.ignite.dao.DogRepository;
import com.ignite.model.Breed;

@RestController
public class BreedController {
	
	@Autowired
    private BreedRepository breedrepo;
	@Autowired
    private DogRepository dogrepo;

	@RequestMapping("/savebreed")
	public void saveBreed() {

		Breed collie = new Breed();
		collie.setId(1L);
		collie.setName("collie");
		// save Breed with name collie
		breedrepo.save(1L, collie);

		System.out.println("Add one breed in the repository!");

	}
	
	@RequestMapping("/getbreeds")
	public List<Breed> getbreeds() {
		 // Query the breed
		  List < Breed > getAllBreeds = breedrepo.getAllBreedsByName("collie");
		  for (Breed breed: getAllBreeds) {
		   System.out.println("Breed:" + breed);
		  }
		  
		  return getAllBreeds;
		  
	}

}
