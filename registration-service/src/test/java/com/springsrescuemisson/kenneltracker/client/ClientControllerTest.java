package com.springsrescuemisson.kenneltracker.client;

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

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.client.dto.ClientRegistrationDto;

public class ClientControllerTest {

    public static final int ID = 1234;
    public static final String PATH_ID = "1234";
    public static final String FIRST_NAME = "John";
    public static final String LAST_NAME = "Doe";
    public static final String PHONE_NUMBER = "7198881122";

    @Mock
    ClientRepository repository;

    ClientController controller;
    AutoCloseable closeable;

    @BeforeEach
    public void setup(){
        closeable = MockitoAnnotations.openMocks(this);
        controller = new ClientController(repository);
    }

    @AfterEach
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void receivedInvaildClientToRegister(){
        ClientRegistrationDto client = ClientRegistrationDto.builder()
                .firstName(FIRST_NAME)
                .build();
        ResponseEntity<String> response = controller.registerClient(client);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void receivedValidClientToRegister_success(){

    	ClientRegistrationDto client = ClientRegistrationDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .phoneNumber(PHONE_NUMBER)
                .build();
        when(repository.save(any(Client.class))).thenReturn(new Client());

        ResponseEntity<String> response = controller.registerClient(client);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void updateClient_clientDidntExist_invalidRequest(){
    	ClientRegistrationDto client = ClientRegistrationDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .build();
        when(repository.findById(ID)).thenReturn(Optional.empty());

        ResponseEntity<ClientDto> response = controller.updateClient(PATH_ID, client);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }


    @Test
    public void updateClient_clientDidntExist_createdNewClient(){
    	ClientRegistrationDto client = ClientRegistrationDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .phoneNumber(PHONE_NUMBER)
                .build();

        when(repository.findById(ID)).thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(new Client());

        ResponseEntity<ClientDto> response = controller.updateClient(PATH_ID, client);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void updateClient_clientExists_updatingNewFields(){
    	ClientRegistrationDto existingClient = ClientRegistrationDto.builder()
                .id(ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .phoneNumber(PHONE_NUMBER)
                .build();
    	
    	ClientRegistrationDto updatedClient = existingClient.toBuilder()
    			.phoneNumber("7198883344")
    			.build();

        when(repository.findById(ID)).thenReturn(Optional.of(ClientMapper.convertToEntity(existingClient)));
        when(repository.save(any())).thenReturn(ClientMapper.convertToEntity(updatedClient));

        ResponseEntity<ClientDto> response = controller.updateClient(PATH_ID, updatedClient);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    public void findAllClients_nothingFound(){
        when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);

        ResponseEntity<List<Client>> response = controller.findAllClients();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void findAllClients_success(){
        when(repository.findAll()).thenReturn( Arrays.asList(new Client()));

        ResponseEntity<List<Client>> response = controller.findAllClients();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertFalse(response.getBody().isEmpty());
    }

    @Test
    public void obtainClientInfo_clientNotFound(){

        when(repository.findById(ID)).thenReturn(Optional.empty());

        ResponseEntity<Client> response = controller.obtainClientInfo(PATH_ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    public void obtainClientInfo_success(){
        when(repository.findById(ID)).thenReturn(Optional.of(new Client()));

        ResponseEntity<Client> response = controller.obtainClientInfo(PATH_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());

    }

    @Test
    public void unregisterClient_clientNotFound(){
        when(repository.findById(ID)).thenReturn(Optional.empty());

        ResponseEntity<HttpStatus> response = controller.unregisterClient(PATH_ID);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void unregisterClient_success(){
        when(repository.findById(ID)).thenReturn(Optional.of(new Client()));

        ResponseEntity<HttpStatus> response = controller.unregisterClient(PATH_ID);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }


}
