package com.springsrescuemisson.kenneltracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.springsrescuemisson.kenneltracker.entity.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
