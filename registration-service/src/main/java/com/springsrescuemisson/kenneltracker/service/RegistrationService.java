package com.springsrescuemisson.kenneltracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsrescuemisson.kenneltracker.entity.Client;
import com.springsrescuemisson.kenneltracker.entity.Pet;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.repository.ClientRepository;
import com.springsrescuemisson.kenneltracker.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationService {

	@Autowired
	ClientRepository clientRepo;

	@Autowired
	PetRepository petRepo;

	public void register(final Client client) throws ValidationException {

		log.info("Validating client #{}", client.getId());

		ValidationService.validate(client);
		
		if (clientRepo.existsById(client.getId()))
			throw new ValidationException("Client already exists.");
		
		clientRepo.save(client);
	}

	public void register(final Pet pet) throws ValidationException {
		log.info("Validating pet #{}", pet.getId());

		ValidationService.validate(pet);
		
		if (petRepo.existsById(pet.getId()))
			throw new ValidationException("Pet already exists.");
		
		petRepo.save(pet);
	}

}
