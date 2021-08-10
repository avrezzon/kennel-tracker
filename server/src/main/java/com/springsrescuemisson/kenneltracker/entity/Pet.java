package com.springsrescuemisson.kenneltracker.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Pet {

	@Id
	private Integer id;
	private String name;
	private String type; //This is the kind of pet (dog, cat, etc.)
	private String breed;
	private String gender;
	private String color;
	private String kennelNumber;
	private Boolean restricted;
	private Set<Client> owners;
	
	//TODO look into the many to many relationships with JPA
	// https://www.baeldung.com/hibernate-one-to-manyhttps://www.baeldung.com/hibernate-many-to-many
	
}
