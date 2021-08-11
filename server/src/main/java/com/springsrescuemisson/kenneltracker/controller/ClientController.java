package com.springsrescuemisson.kenneltracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springsrescuemisson.kenneltracker.entity.Client;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.service.RegistrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/registry/client")
public class ClientController {
	
		@Autowired
		RegistrationService registrationService;
	
		@PostMapping
		public ResponseEntity<String> registerClient(@RequestBody Client client) {
			
			ResponseEntity<String> response;
			String message;
			
			log.info("Recieved request to register client id #{}", client.getId());
			log.debug("Requested Client to register: {}", client);
			
			try{
				
				registrationService.register(client);
				message = "Sucessfully Registered Client";
				response = new ResponseEntity<>(message, HttpStatus.OK);
				
			}catch(ValidationException ve) {
				
				message = String.format("Failed to register client due to invlaid request. Reason: %s", ve.getMessage());
				response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		
			}catch(Exception e) {
				
				message = String.format("Failed to register client. Reason: %s", e.getMessage());
				response = new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		
			}
			
			return response;
		}
		
		@GetMapping
		public ResponseEntity<List<Client>> findAllClients(){
			return null;
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Client> obtainClientInfo(@PathVariable String id){
			return null;
		}
		
		@PutMapping
		public ResponseEntity<Client> updateClient(@RequestBody Client client){
			return null;
		}
		
		@DeleteMapping
		public ResponseEntity<Client> unregisterClient(){
			return null;
		}
}
