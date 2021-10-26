package com.springsrescuemisson.kenneltracker.pet;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer> {
	public Optional<Pet> findByName(String name);
}
