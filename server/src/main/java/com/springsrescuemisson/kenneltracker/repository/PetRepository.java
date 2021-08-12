package com.springsrescuemisson.kenneltracker.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.springsrescuemisson.kenneltracker.entity.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {
	public Optional<Pet> findByName(String name);
}
