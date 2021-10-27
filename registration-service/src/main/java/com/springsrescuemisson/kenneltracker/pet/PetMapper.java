package com.springsrescuemisson.kenneltracker.pet;

import java.util.stream.Collectors;

import com.springsrescuemisson.kenneltracker.client.ClientMapper;

public class PetMapper {

	public static Pet convertToEntity(PetRegistrationDto dto) {

		return Pet.builder()
				.id(Integer.valueOf(dto.getId()))
				.name(dto.getName())
				.type(dto.getType())
				.breed(dto.getBreed())
				.gender(dto.getGender())
				.color(dto.getColor())
				.kennelNumber(dto.getKennelNumber())
				.build();

	}

	public static PetDto convertToDto(Pet entity, boolean displayOwners) {
		return PetDto.builder()
				.id(entity.getId().toString())
				.type(entity.getType())
				.kennelNumber(entity.getKennelNumber())
				.name(entity.getName())
				.owners(entity.getOwners()
						.stream()
						.map(x -> ClientMapper.convertToDto(x, false))
						.collect(Collectors.toList()))
				.build();
	}
}
