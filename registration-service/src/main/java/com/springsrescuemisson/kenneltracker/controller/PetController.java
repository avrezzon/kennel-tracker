package com.springsrescuemisson.kenneltracker.controller;

import com.springsrescuemisson.kenneltracker.repository.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/registry/pet")
public class PetController {

	@Autowired
	PetRepository pets;
//
//	@PostMapping
//	public ResponseEntity<String> registerPet(@RequestBody PetDto pet) {
//		ResponseEntity<String> response;
//		String message;
//
//		log.info("Recieved request to register pet id #{}", pet.getId());
//		log.debug("Requested Pet to register: {}", pet);
//
//		try{
//			ValidationService.validate(pet);
//			pets.save(pet);
//			response = new ResponseEntity<>("Sucessfully Registered Pet", HttpStatus.OK);
//
//		}catch(ValidationException ve) {
//
//			message = String.format("Failed to register pet due to invlaid request. Reason: %s", ve.getMessage());
//			response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
//
//		}
//
//		return response;
//	}
//
//	@GetMapping
//	public ResponseEntity<List<Pet>> findAllPets(){
//		List<Pet> registeredClients = (List<Pet>) pets.findAll();
//		return new ResponseEntity<>(registeredClients, HttpStatus.OK);
//	}
//
//	@GetMapping("/{id}")
//	public ResponseEntity<Pet> obtainPetInfoFromOwnerId(@PathVariable String id){
//		return null;
//	}
//
//	@PutMapping
//	public ResponseEntity<Pet> updatePet(@RequestBody Pet pet){
//		return null;
//	}
//
//	@DeleteMapping
//	public ResponseEntity<Pet> unregisterPet(){
//		return null;
//	}
	
	//Need to add something for restricting a pet
	
}
