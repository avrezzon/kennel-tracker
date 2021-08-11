package com.springsrescuemisson.kenneltracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springsrescuemisson.kenneltracker.entity.Client;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.repository.ClientRepository;
import com.springsrescuemisson.kenneltracker.repository.PetRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RegistrationService {

	private static final String REGISTRATION_SUCCESSFUL = "Registration Successful";

	@Autowired
	ClientRepository clientRepo;

	@Autowired
	PetRepository petRepo;

	public String register(final Client client) throws ValidationException {

		log.info("Validating client #{}", client.getId());

		ValidationService.validate(client);

		clientRepo.save(client);

		return "";

	}

}
