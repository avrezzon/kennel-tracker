package com.springsrescuemisson.kenneltracker.pet;

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
@RequestMapping("/registry/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetRepository repository;

    @PostMapping
    public ResponseEntity<String> registerPet(@RequestBody PetDto pet) {

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
    public ResponseEntity<PetDto> updatePet(@PathVariable String id, @RequestBody PetDto dto) {

        Optional<Pet> potentialPet = repository.findById(Integer.valueOf(id));
        if (potentialPet.isEmpty()) {
            try {
                ValidationService.validate(dto);
                Pet persistedEntity = repository.save(PetMapper.convertToEntity(dto));
                return new ResponseEntity<>(PetMapper.convertToDto(persistedEntity), HttpStatus.CREATED);
            } catch (ValidationException ve) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } else {
            throw new NotImplementedException("Need to patch the entity");
        }
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
