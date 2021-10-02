package com.springsrescuemisson.kenneltracker.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Builder
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
	
	@ManyToMany(targetEntity = Pet.class, mappedBy = "owners")
	private Set<Pet> pets;
}
