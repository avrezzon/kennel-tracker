package com.springsrescuemisson.kenneltracker.client;

import java.util.stream.Collectors;

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.client.dto.ClientRegistrationDto;
import com.springsrescuemisson.kenneltracker.pet.PetMapper;

public class ClientMapper{

    public static Client convertToEntity(ClientRegistrationDto dto) {
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

    public static ClientDto convertToDto(Client entity) {
        return ClientDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .pets(entity.getPets()
                		.stream()
                		.map(PetMapper::convertToDto)
                		.collect(Collectors.toList()))
                .build();
    }
}
