package com.springsrescuemisson.kenneltracker.registry;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsrescuemisson.kenneltracker.client.Client;
import com.springsrescuemisson.kenneltracker.client.ClientRepository;
import com.springsrescuemisson.kenneltracker.pet.Pet;
import com.springsrescuemisson.kenneltracker.pet.PetRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registry")
public class RegistryController {
	
	private final ClientRepository clientRepo;
	private final PetRepository petRepo;
	

	@PostMapping("/assignPet/{clientId}/{petId}")
	public void registerPetToOwner(@PathVariable String clientId, @PathVariable String petId) {
		
		Client client = clientRepo.findById(Integer.valueOf(clientId)).get();
		Pet pet = petRepo.findById(Integer.valueOf(petId)).get();
		
		Set<Pet> pets;
		
		if(client.getPets() == null) {
			pets = new HashSet<>();
		}else {
			pets = client.getPets();
		}
		
		pets.add(pet);
		
		client.setPets(pets);
		clientRepo.save(client);
		
	}
	
}
