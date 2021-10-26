package com.springsrescuemisson.kenneltracker.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.client.dto.ClientRegistrationDto;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.pet.PetDto;

public class ValidationServiceTest {

	ClientRegistrationDto client;
    PetDto pet;

    @Test
    public void verifyClientDto_idContainsInvalidNumber(){
        client = ClientRegistrationDto.builder()
                .id(0)
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(client);
                }
        );

        assertEquals("Client ID is not a valid number", exception.getMessage());
    }

    @Test
    public void verifyClientDto_idIsNull(){
        client = ClientRegistrationDto.builder().build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(client);
                }
        );

        assertEquals("Client ID is not a valid number", exception.getMessage());
    }

    @Test
    public void verifyClientDto_firstNameIsMissing(){
        client = ClientRegistrationDto.builder()
                .id(1234)
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(client);
                }
        );

        assertEquals("Client first name is required", exception.getMessage());
    }

    @Test
    public void verifyClientDto_lastNameIsMissing(){
        client = ClientRegistrationDto.builder()
                .id(1234)
                .firstName("John")
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(client);
                }
        );

        assertEquals("Client last name is required", exception.getMessage());
    }

    @Test
    public void verifyClientDto_phoneNumberIsMissing(){
        client = ClientRegistrationDto.builder()
                .id(1234)
                .firstName("John")
                .lastName("Doe")
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(client);
                }
        );

        assertEquals("Client phone number is required", exception.getMessage());
    }

    @Test
    public void verifyClientDto_success(){
        client = ClientRegistrationDto.builder()
                .id(1234)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("7198881122")
                .build();

        assertDoesNotThrow( () -> {
                    ValidationService.validate(client);
                }
        );
    }

    @Test
    public void verifyPetDto_nameIsMissing(){
        pet = PetDto.builder().build();

        Throwable exception = assertThrows(
                    ValidationException.class, () -> {
                    ValidationService.validate(pet);
                }
        );

        assertEquals("Pet name is required", exception.getMessage());
    }

    @Test
    public void verifyPetDto_typeIsMissing(){
        pet = PetDto.builder()
                .name("Fluffy")
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(pet);
                }
        );

        assertEquals("Pet type is required", exception.getMessage());
    }

    @Test
    public void verifyPetDto_breedIsMissing(){
        pet = PetDto.builder().name("Fluffy")
                .type("Dog")
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(pet);
                }
        );

        assertEquals("Pet breed is required", exception.getMessage());
    }

    @Test
    public void verifyPetDto_kennelNumberIsMissing(){
        pet = PetDto.builder().name("Fluffy")
                .type("Dog")
                .breed("Husky")
                .build();

        Throwable exception = assertThrows(
                ValidationException.class, () -> {
                    ValidationService.validate(pet);
                }
        );

        assertEquals("Current kennel number is required", exception.getMessage());
    }

    @Test
    public void verifyPetDto_success(){
        pet = PetDto.builder().name("Fluffy")
                .type("Dog")
                .breed("Husky")
                .kennelNumber("12")
                .build();

        assertDoesNotThrow( () -> {
                    ValidationService.validate(pet);
                }
        );
}

}
