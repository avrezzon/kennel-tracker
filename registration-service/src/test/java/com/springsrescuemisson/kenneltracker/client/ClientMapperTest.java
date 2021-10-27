package com.springsrescuemisson.kenneltracker.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;

public class ClientMapperTest {

    ClientMapper mapper;

    final Client entity = Client.builder()
                                .id(1234)
                                .firstName("John")
                                .lastName("Doe")
                                .bedNumber(12)
                                .phoneNumber("7198881122")
                                .emergencyContact("7198882233")
                                .build();

    final ClientDto dto = ClientDto.builder()
                                .id(1234)
                                .firstName("John")
                                .lastName("Doe")
                                .pets(Collections.emptyList())
                                .build();

    @BeforeEach
    public void setup(){
        mapper = new ClientMapper();
    }

    //FIXME
    //@Test
    public void convertToEntity_success(){
//        Client actual = mapper.convertToEntity(dto);
//        assertEquals(entity, actual);
    }

    @Test
    public void convertToDto_success(){
        ClientDto actual = mapper.convertToDto(entity, false);
        assertEquals(dto, actual);
    }

}
