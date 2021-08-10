package com.springsrescuemisson.kenneltracker.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsrescuemisson.kenneltracker.entity.Pet;

@RestController
@RequestMapping("/registry/pet")
public class PetController {

	@PostMapping
	public ResponseEntity<Pet> registerPet(@RequestBody Pet pet) {
		return null;
	}
	
	@GetMapping
	public ResponseEntity<List<Pet>> findAllPets(){
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pet> obtainPetInfoFromOwnerId(@PathVariable String id){
		return null;
	}
	
	@PutMapping
	public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){
		return null;
	}
	
	@DeleteMapping
	public ResponseEntity<Pet> unregisterPet(){
		return null;
	}
	
	//Need to add something for restricting a pet
	
}
