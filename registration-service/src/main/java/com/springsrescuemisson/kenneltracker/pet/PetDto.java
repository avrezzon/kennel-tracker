package com.springsrescuemisson.kenneltracker.pet;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetDto {

    private String id;
    private String name;
    private String type; //This is the kind of pet (dog, cat, etc.)
    private String breed;
    private String gender;
    private String color;
    private String kennelNumber;
    
    private Optional<Set<ClientDto>> owners;
}
