package com.springsrescuemisson.kenneltracker.service;



import com.springsrescuemisson.kenneltracker.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.dto.PetDto;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import org.apache.commons.lang3.StringUtils;

public class ValidationService {

	public static void validate(final ClientDto client) throws ValidationException {
		if(client.getId() == null || client.getId() <= 0 )
			throw new ValidationException("Client ID is not a valid number");
		
		if(StringUtils.isEmpty(client.getFirstName()))
			throw new ValidationException("Client first name is required");
		
		if(StringUtils.isEmpty(client.getLastName()))
			throw new ValidationException("Client last name is required");
		
		if(StringUtils.isEmpty(client.getPhoneNumber())) //TODO add regex for this, might want to also validate on the client side
			throw new ValidationException("Client phone number is required");
	}
	
	public static void validate(final PetDto pet) throws ValidationException{
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
