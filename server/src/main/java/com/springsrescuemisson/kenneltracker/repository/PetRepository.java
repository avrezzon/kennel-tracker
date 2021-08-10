package com.springsrescuemisson.kenneltracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.springsrescuemisson.kenneltracker.entity.Pet;

public interface PetRepository extends CrudRepository<Pet, Integer> {

}
