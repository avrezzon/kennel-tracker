package com.springsrescuemisson.kenneltracker.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Builder
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

	@ManyToMany
	private Set<Client> owners;
}
