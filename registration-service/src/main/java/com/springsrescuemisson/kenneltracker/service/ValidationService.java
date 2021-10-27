package com.springsrescuemisson.kenneltracker.service;



import org.apache.commons.lang3.StringUtils;

import com.springsrescuemisson.kenneltracker.client.dto.ClientRegistrationDto;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.pet.PetRegistrationDto;

public class ValidationService {

	public static void validate(final ClientRegistrationDto client) throws ValidationException {
		if(client.getId() == null || client.getId() <= 0 )
			throw new ValidationException("Client ID is not a valid number");
		
		if(StringUtils.isEmpty(client.getFirstName()))
			throw new ValidationException("Client first name is required");
		
		if(StringUtils.isEmpty(client.getLastName()))
			throw new ValidationException("Client last name is required");
		
		if(StringUtils.isEmpty(client.getPhoneNumber())) //TODO add regex for this, might want to also validate on the client side
			throw new ValidationException("Client phone number is required");
	}
	
	public static void validate(final PetRegistrationDto pet) throws ValidationException{
		if(pet.getId() == null || pet.getId() <= 0 )
			throw new ValidationException("Pet ID is not a valid number");
		if(StringUtils.isEmpty(pet.getName()))
			throw new ValidationException("Pet name is required");
		
		if(StringUtils.isEmpty(pet.getType()))
			throw new ValidationException("Pet type is required");
		
		if(StringUtils.isEmpty(pet.getBreed()))
			throw new ValidationException("Pet breed is required");
		
		if(StringUtils.isEmpty(pet.getKennelNumber()))
			throw new ValidationException("Current kennel number is required");
		
	}
	
}
