package com.springsrescuemisson.kenneltracker.client;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.springsrescuemisson.kenneltracker.pet.Pet;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Client {

	@Id
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emergencyContact; //Phone number of the contact
	private String shelterType;
	private Integer bedNumber;
	
	@Builder.Default
	@ManyToMany(targetEntity = Pet.class, mappedBy = "owners")
	private Set<Pet> pets = Collections.emptySet();

}
