package com.springsrescuemisson.kenneltracker.dto;

import java.util.Optional;

import lombok.Data;

@Data
public class ClientDto {
	private Optional<Integer> bedNumber;
	private Optional<String> emergencyContact;
	private Optional<String> firstName;
	private Optional<String> lastName;
	
}
