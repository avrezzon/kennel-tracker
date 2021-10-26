package com.springsrescuemisson.kenneltracker.client.dto;

import java.util.List;

import com.springsrescuemisson.kenneltracker.pet.PetDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private List<PetDto> pets;
	
}
