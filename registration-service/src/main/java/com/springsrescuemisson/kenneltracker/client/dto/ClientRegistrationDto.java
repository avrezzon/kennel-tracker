package com.springsrescuemisson.kenneltracker.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ClientRegistrationDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String emergencyContact;
	private String shelterType;
	private Integer bedNumber;

}
