package com.springsrescuemisson.kenneltracker.pet;

import java.util.Optional;
import java.util.stream.Collectors;

import com.springsrescuemisson.kenneltracker.client.ClientMapper;

import ch.qos.logback.core.net.server.Client;

public class PetMapper {

	public static Pet convertToEntity(PetDto dto) {

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

	public static PetDto convertToDto(Pet entity) {
		return PetDto.builder()
				.id(entity.getId().toString())
				.breed(entity.getBreed())
				.color(entity.getColor())
				.gender(entity.getGender())
				.kennelNumber(entity.getKennelNumber())
				.name(entity.getName())
				.build();
	}
}
