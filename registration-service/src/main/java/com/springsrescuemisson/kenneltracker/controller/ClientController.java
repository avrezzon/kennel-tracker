package com.springsrescuemisson.kenneltracker.controller;

import java.util.List;
import java.util.Optional;

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

import com.springsrescuemisson.kenneltracker.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.entity.Client;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.mapper.ClientMapper;
import com.springsrescuemisson.kenneltracker.repository.ClientRepository;
import com.springsrescuemisson.kenneltracker.service.ValidationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/registry/client")
public class ClientController {
		
		@Autowired
		ClientRepository clients;
		
		@Autowired
		ClientMapper mapper;
			
		@PostMapping
		public ResponseEntity<String> registerClient(@RequestBody Client client) {
			
			ResponseEntity<String> response;
			String message;
			
			log.info("Recieved request to register client id #{}", client.getId());
			log.debug("Requested Client to register: {}", client);
			
			try{
				
				ValidationService.validate(client);
				clients.save(client);
				response = new ResponseEntity<>("Sucessfully Registered Client", HttpStatus.OK);
				
			}catch(ValidationException ve) {
				
				message = String.format("Failed to register client due to invlaid request. Reason: %s", ve.getMessage());
				response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		
			}
			
			return response;
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody ClientDto dto){
			Client client;
			
			Optional<Client> potentialClient = clients.findById(Integer.valueOf(id));
			
			if(potentialClient.isEmpty()) {
				client = new Client();
				client.setId(Integer.valueOf(id));
				mapper.updateClientFromDto(dto, client);
				client = clients.save(client);
				return new ResponseEntity<>(client, HttpStatus.CREATED);
			}else {
				client = potentialClient.get();
				mapper.updateClientFromDto(dto, client);
				try {
					ValidationService.validate(client);
					clients.save(client);
					return new ResponseEntity<>(client, HttpStatus.OK);
				} catch (ValidationException e) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
				
			}
	
		}
		
		@GetMapping
		public ResponseEntity<List<Client>> findAllClients(){		
			List<Client> registeredClients = (List<Client>) clients.findAll();
			return (registeredClients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(registeredClients, HttpStatus.OK);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Client> obtainClientInfo(@PathVariable String id){
			Optional<Client> client = clients.findById(Integer.valueOf(id));
			return (client.isPresent()) ? (new ResponseEntity<>(client.get(), HttpStatus.OK)) : (new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
		}
		
		
		@DeleteMapping("/{id}")
		public ResponseEntity<HttpStatus> unregisterClient(@PathVariable String id){
			Optional<Client> potentialClient = clients.findById(Integer.valueOf(id));
			if(potentialClient.isPresent()) {
				clients.deleteById(Integer.valueOf(id));
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
}
