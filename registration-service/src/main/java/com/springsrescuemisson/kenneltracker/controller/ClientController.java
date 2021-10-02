package com.springsrescuemisson.kenneltracker.controller;

import com.springsrescuemisson.kenneltracker.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.entity.Client;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.mapper.ClientMapper;
import com.springsrescuemisson.kenneltracker.repository.ClientRepository;
import com.springsrescuemisson.kenneltracker.service.ValidationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/registry/client")
@RequiredArgsConstructor
public class ClientController {

		private final ClientRepository repository;
		private final ClientMapper mapper;
			
		@PostMapping
		public ResponseEntity<String> registerClient(@RequestBody ClientDto client) {
			
			ResponseEntity<String> response;
			String message;
			
			log.info("Recieved request to register client id #{}", client.getId());
			log.debug("Requested Client to register: {}", client);
			
			try{
				
				ValidationService.validate(client);
				Client user = mapper.convertToEntity(client);
				repository.save(user);
				response = new ResponseEntity<>("Sucessfully Registered Client", HttpStatus.OK);
				
			}catch(ValidationException ve) {
				
				message = String.format("Failed to register client due to invlaid request. Reason: %s", ve.getMessage());
				response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		
			}
			
			return response;
		}

		@PutMapping("/{id}")
		public ResponseEntity<ClientDto> updateClient(@PathVariable String id, @RequestBody ClientDto dto){

			Optional<Client> potentialClient = repository.findById(Integer.valueOf(id));
			if(potentialClient.isEmpty()){
				try{
					ValidationService.validate(dto);
					Client persistedEntity = repository.save(ClientMapper.convertToEntity(dto));
					return new ResponseEntity<>(ClientMapper.convertToDto(persistedEntity),HttpStatus.CREATED);
				}catch(ValidationException ve){
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
			}else {
				throw new NotImplementedException("Need to patch the entity");
			}
		}

		//TODO add security for only admins to retrieve this info
		@GetMapping
		public ResponseEntity<List<Client>> findAllClients(){
			List<Client> registeredClients = (List<Client>) repository.findAll();
			return (registeredClients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NOT_FOUND): new ResponseEntity<>(registeredClients, HttpStatus.OK);
		}

		//TODO Add security mapping for this
		@GetMapping("/{id}")
		public ResponseEntity<Client> obtainClientInfo(@PathVariable String id){
			Optional<Client> client = repository.findById(Integer.valueOf(id));
			return (client.isPresent()) ? (new ResponseEntity<>(client.get(), HttpStatus.OK)) : (new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
		}


		@DeleteMapping("/{id}")
		public ResponseEntity<HttpStatus> unregisterClient(@PathVariable String id){
			Optional<Client> potentialClient = repository.findById(Integer.valueOf(id));
			if(potentialClient.isPresent()) {
				repository.deleteById(Integer.valueOf(id));
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
}
