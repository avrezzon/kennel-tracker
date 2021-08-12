package com.springsrescuemisson.kenneltracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.repository.PetRepository;
import com.springsrescuemisson.kenneltracker.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/registry/pet")
public class PetController {

	@Autowired
	PetRepository pets;
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping
	public ResponseEntity<String> registerPet(@RequestBody Pet pet) {
		ResponseEntity<String> response;
		String message;
		
		log.info("Recieved request to register pet id #{}", pet.getId());
		log.debug("Requested Pet to register: {}", pet);
		
		try{
			
			registrationService.register(pet);
			message = "Sucessfully Registered Petpet";
			response = new ResponseEntity<>(message, HttpStatus.OK);
			
		}catch(ValidationException ve) {
			
			message = String.format("Failed to register pet due to invlaid request. Reason: %s", ve.getMessage());
			response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	
		}catch(Exception e) {
			
			message = String.format("Failed to register pet. Reason: %s", e.getMessage());
			response = new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	
		}
		
		return response;
	}
	
	@GetMapping
	public ResponseEntity<List<Pet>> findAllPets(){
		List<Pet> registeredClients = (List<Pet>) pets.findAll();
		return new ResponseEntity<>(registeredClients, HttpStatus.OK);
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
