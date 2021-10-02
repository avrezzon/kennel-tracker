package com.springsrescuemisson.kenneltracker.mapper;

import com.springsrescuemisson.kenneltracker.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<ClientDto, Client>{
    @Override
    public Client convertToEntity(ClientDto dto) {
        return Client.builder()
                .id(dto.getId())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .phoneNumber(dto.getPhoneNumber())
                .emergencyContact(dto.getEmergencyContact())
                .shelterType(dto.getShelterType())
                .bedNumber(dto.getBedNumber())
                .build();
    }

    @Override
    public ClientDto convertToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .phoneNumber(entity.getPhoneNumber())
                .emergencyContact(entity.getEmergencyContact())
                .shelterType(entity.getShelterType())
                .bedNumber(entity.getBedNumber())
                .build();
    }
}
