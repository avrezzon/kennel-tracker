package com.springsrescuemisson.kenneltracker.pet;

import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.springsrescuemisson.kenneltracker.client.Client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

	@Builder.Default
	@ManyToMany
	private List<Client> owners =  Collections.emptyList();
}
