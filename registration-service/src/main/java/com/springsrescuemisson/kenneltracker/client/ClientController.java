package com.springsrescuemisson.kenneltracker.client;

import com.springsrescuemisson.kenneltracker.client.dto.ClientDto;
import com.springsrescuemisson.kenneltracker.client.dto.ClientRegistrationDto;
import com.springsrescuemisson.kenneltracker.exception.ValidationException;
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

	@PostMapping
	public ResponseEntity<String> registerClient(@RequestBody ClientRegistrationDto client) {

		ResponseEntity<String> response;
		String message;

		log.info("Received request to register client id #{}", client.getId());
		log.debug("Requested Client to register: {}", client);

		try {

			ValidationService.validate(client);
			Client user = ClientMapper.convertToEntity(client);
			repository.save(user);
			response = new ResponseEntity<>("Successfully Registered Client", HttpStatus.OK);

		} catch (ValidationException ve) {

			message = String.format("Failed to register client due to invalid request. Reason: %s", ve.getMessage());
			response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

		}

		return response;
	}

	@PutMapping("/{id}") // TODO Consider uppdated Dto to show the items that changed
	public ResponseEntity<ClientDto> updateClient(@PathVariable String id, @RequestBody ClientRegistrationDto dto) {

		try {
			ValidationService.validate(dto);
		} catch (ValidationException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<Client> potentialClient = repository.findById(Integer.valueOf(id));
		Client persistedEntity = repository.save(ClientMapper.convertToEntity(dto));
		return new ResponseEntity<>(ClientMapper.convertToDto(persistedEntity, false),
				(potentialClient.isEmpty())? HttpStatus.CREATED: HttpStatus.OK);
	}

	// TODO add security for only admins to retrieve this info
	@GetMapping
	public ResponseEntity<List<Client>> findAllClients() {
		List<Client> registeredClients = (List<Client>) repository.findAll();
		return (registeredClients.isEmpty()) ? new ResponseEntity<>(HttpStatus.NOT_FOUND)
				: new ResponseEntity<>(registeredClients, HttpStatus.OK);
	}

	// TODO Add security mapping for this
	@GetMapping("/{id}")
	public ResponseEntity<Client> obtainClientInfo(@PathVariable String id) {
		Optional<Client> client = repository.findById(Integer.valueOf(id));
		return client.map(value -> (new ResponseEntity<>(value, HttpStatus.OK)))
				.orElseGet(() -> (new ResponseEntity<>(null, HttpStatus.NOT_FOUND)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> unregisterClient(@PathVariable String id) {
		Optional<Client> potentialClient = repository.findById(Integer.valueOf(id));
		if (potentialClient.isPresent()) {
			repository.deleteById(Integer.valueOf(id));
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// TODO Create patch method
}
