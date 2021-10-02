package com.springsrescuemisson.kenneltracker.mapper;

import com.springsrescuemisson.kenneltracker.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.entity.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                                .bedNumber(12)
                                .phoneNumber("7198881122")
                                .emergencyContact("7198882233")
                                .build();

    @Before
    public void setup(){
        mapper = new ClientMapper();
    }

    @Test
    public void convertToEntity_success(){
        Client actual = mapper.convertToEntity(dto);
        assertEquals(entity, actual);
    }

    @Test
    public void convertToDto_success(){
        ClientDto actual = mapper.convertToDto(entity);
        assertEquals(dto, actual);
    }

}
