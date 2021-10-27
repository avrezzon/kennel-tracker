package com.springsrescuemisson.kenneltracker.pet;

import java.util.List;
import java.util.Optional;

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

import com.springsrescuemisson.kenneltracker.exception.ValidationException;
import com.springsrescuemisson.kenneltracker.service.ValidationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/registry/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetRepository repository;

    @PostMapping
    public ResponseEntity<String> registerPet(@RequestBody PetRegistrationDto pet) {

        ResponseEntity<String> response;
        String message;

        log.info("Received request to register Pet id #{}", pet.getId());
        log.debug("Requested Pet to register: {}", pet);

        try {

            ValidationService.validate(pet);
            Pet animal = PetMapper.convertToEntity(pet);
            repository.save(animal);
            response = new ResponseEntity<>("Successfully Registered Pet", HttpStatus.OK);

        } catch (ValidationException ve) {

            message = String.format("Failed to register Pet due to invalid request. Reason: %s", ve.getMessage());
            response = new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);

        }

        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDto> updatePet(@PathVariable String id, @RequestBody PetRegistrationDto dto) {

		try {
			ValidationService.validate(dto);
		} catch (ValidationException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Optional<Pet> potentialPet = repository.findById(Integer.valueOf(id));
		Pet persistedEntity = repository.save(PetMapper.convertToEntity(dto));
		return new ResponseEntity<>(PetMapper.convertToDto(persistedEntity, false),
				(potentialPet.isEmpty())? HttpStatus.CREATED: HttpStatus.OK);
    }

    //TODO add security for only admins to retrieve this info
    @GetMapping
    public ResponseEntity<List<Pet>> findAllPets() {
        List<Pet> registeredPets = (List<Pet>) repository.findAll();
        return (registeredPets.isEmpty()) ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(registeredPets, HttpStatus.OK);
    }

    //TODO Add security mapping for this
    @GetMapping("/{id}")
    public ResponseEntity<Pet> obtainPetInfo(@PathVariable String id) {
        Optional<Pet> Pet = repository.findById(Integer.valueOf(id));
        return Pet.map(value -> (new ResponseEntity<>(value, HttpStatus.OK))).orElseGet(() -> (new ResponseEntity<>(null, HttpStatus.NOT_FOUND)));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> unregisterPet(@PathVariable String id) {
        Optional<Pet> potentialPet = repository.findById(Integer.valueOf(id));
        if (potentialPet.isPresent()) {
            repository.deleteById(Integer.valueOf(id));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Need to add something for restricting a pet
    //TODO implement patch method

}
