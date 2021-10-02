package com.springsrescuemisson.kenneltracker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emergencyContact;
	private String shelterType;
	private Integer bedNumber;
}
