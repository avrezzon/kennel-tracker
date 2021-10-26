package com.springsrescuemisson.kenneltracker.pet;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.springsrescuemisson.kenneltracker.client.Client;

import java.util.Set;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pet {

	@Id
	private Integer id;
	private String name;
	private String type; //This is the kind of pet (dog, cat, etc.)
	private String breed;
	private String gender;
	private String color;
	private String kennelNumber; //Foreign key
	private Boolean restricted;

	@ManyToMany
	private Set<Client> owners;
}
