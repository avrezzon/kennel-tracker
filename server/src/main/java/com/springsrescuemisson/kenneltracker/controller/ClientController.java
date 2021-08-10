package com.springsrescuemisson.kenneltracker.controller;

import java.util.List;

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

@RestController
@RequestMapping("/registry/client")
public class ClientController {
	
		@PostMapping
		public ResponseEntity<Client> registerClient(@RequestBody Client client) {
			return null;
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
