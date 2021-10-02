package com.springsrescuemisson.kenneltracker;

import com.springsrescuemisson.kenneltracker.controller.ClientController;
import com.springsrescuemisson.kenneltracker.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.entity.Client;
import com.springsrescuemisson.kenneltracker.mapper.ClientMapper;
import com.springsrescuemisson.kenneltracker.repository.ClientRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest
public class ClientControllerTest {

    @Mock
    ClientRepository repository;

    @Mock
    ClientMapper mapper;

    ClientController controller;
    AutoCloseable closeable;

    @Before
    public void setup(){
        closeable = MockitoAnnotations.openMocks(this);
        controller = new ClientController(repository, mapper);
    }

    @After
    public void releaseMocks() throws Exception {
        closeable.close();
    }

    @Test
    public void receivedInvaildClientToRegister(){
        ClientDto client = ClientDto.builder()
                .firstName("John")
                .bedNumber(1)
                .build();
        ResponseEntity<String> response = controller.registerClient(client);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void receivedValidClientToRegister_success(){

        ClientDto client = ClientDto.builder()
                .id(1234)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("7198881122")
                .build();
        when(repository.save(any(Client.class))).thenReturn(new Client());

        ResponseEntity<String> response = controller.registerClient(client);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }




}
