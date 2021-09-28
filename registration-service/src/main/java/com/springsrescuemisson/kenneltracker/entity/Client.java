package com.springsrescuemisson.kenneltracker.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Data
@Entity
public class Client {

	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emergencyContact; //Phone number of the contact
	private String shelterType;
	private Integer bedNumber;
	
	@ManyToMany(targetEntity = Pet.class, mappedBy = "owners")
	private Set<Pet> pets;
}
