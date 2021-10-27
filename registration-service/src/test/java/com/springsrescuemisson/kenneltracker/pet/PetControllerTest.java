package com.springsrescuemisson.kenneltracker.pet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



public class PetControllerTest {
	
    private static final String KENNEL = "12";
	private static final String BREED = "Husky";
	private static final String TYPE = "Dog";
	private static final String NAME = "Fluffy";
	private static final Integer PET_ID  = 1;
	private static final String PATH_ID = "1";


    @Mock
    PetRepository repository;

    PetController controller;
    AutoCloseable closeable;

    @BeforeEach
    public void setup(){
        closeable = MockitoAnnotations.openMocks(this);
        controller = new PetController(repository);
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void receivedInvaildPetToRegister(){
        PetRegistrationDto pet = PetRegistrationDto.builder()
        		.id(PET_ID)
                .name(NAME)
                .build();
        ResponseEntity<String> response = controller.registerPet(pet);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void receivedValidPetToRegister_success(){

    	PetRegistrationDto pet = PetRegistrationDto.builder()
    			.id(PET_ID)
    			.name(NAME)
                .type(TYPE)
                .breed(BREED)
                .kennelNumber(KENNEL)
                .build();
        when(repository.save(any(Pet.class))).thenReturn(new Pet());

        ResponseEntity<String> response = controller.registerPet(pet);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void updatePet_petDidntExist_invalidRequest(){
    	PetRegistrationDto pet = PetRegistrationDto.builder()
    			.id(PET_ID)
                .build();
        when(repository.findById(PET_ID)).thenReturn(Optional.empty());

        ResponseEntity<PetDto> response = controller.updatePet(PATH_ID, pet);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }


    @Test
    public void updatePet_petDidntExist_createdNewPet(){
    	PetRegistrationDto pet = PetRegistrationDto.builder()
    			.id(PET_ID)
    			.name(NAME)
                .type(TYPE)
                .breed(BREED)
                .kennelNumber(KENNEL)
                .build();

        when(repository.findById(PET_ID)).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(PetMapper.convertToEntity(pet));

        ResponseEntity<PetDto> response = controller.updatePet(PATH_ID, pet);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void updatePet_petExists_updatingNewFields(){
    	PetRegistrationDto existingPet = PetRegistrationDto.builder()
    			.id(PET_ID)
                .name(NAME)
                .type(TYPE)
                .breed(BREED)
                .kennelNumber(KENNEL)
                .build();
    	
    	PetRegistrationDto updatedPet = existingPet.toBuilder()
    			.kennelNumber("7198883344")
    			.build();

        when(repository.findById(PET_ID)).thenReturn(Optional.of(PetMapper.convertToEntity(existingPet)));
        when(repository.save(any())).thenReturn(PetMapper.convertToEntity(updatedPet));

        ResponseEntity<PetDto> response = controller.updatePet(PATH_ID, updatedPet);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void findAllPets_nothingFound(){
        when(repository.findAll()).thenReturn(Collections.emptyList());

        ResponseEntity<List<Pet>> response = controller.findAllPets();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void findAllPets_success(){
        when(repository.findAll()).thenReturn( Arrays.asList(new Pet()));

        ResponseEntity<List<Pet>> response = controller.findAllPets();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void obtainPetInfo_petNotFound(){

        when(repository.findById(PET_ID)).thenReturn(Optional.empty());

        ResponseEntity<Pet> response = controller.obtainPetInfo(PATH_ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void obtainPetInfo_success(){
        when(repository.findById(PET_ID)).thenReturn(Optional.of(new Pet()));

        ResponseEntity<Pet> response = controller.obtainPetInfo(PATH_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }

    @Test
    public void unregisterPet_petNotFound(){
        when(repository.findById(PET_ID)).thenReturn(Optional.empty());

        ResponseEntity<HttpStatus> response = controller.unregisterPet(PATH_ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void unregisterPet_success(){
        when(repository.findById(PET_ID)).thenReturn(Optional.of(new Pet()));

        ResponseEntity<HttpStatus> response = controller.unregisterPet(PATH_ID);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }


}
