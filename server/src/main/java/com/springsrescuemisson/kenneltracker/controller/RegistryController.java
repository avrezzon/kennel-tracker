package com.springsrescuemisson.kenneltracker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsrescuemisson.kenneltracker.message.PetRegistrationRequest;

@RestController
@RequestMapping("registry")
public class RegistryController {

	@PostMapping("/assignPet")
	public void registerPetToOwner(@RequestBody PetRegistrationRequest request) {}
	
}
