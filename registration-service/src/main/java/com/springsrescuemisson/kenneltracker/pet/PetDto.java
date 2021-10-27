package com.springsrescuemisson.kenneltracker.pet;

import java.util.List;

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetDto {

    private String id;
    private String name;
    private String type;
    private String kennelNumber;
    private List<ClientDto> owners;
}
