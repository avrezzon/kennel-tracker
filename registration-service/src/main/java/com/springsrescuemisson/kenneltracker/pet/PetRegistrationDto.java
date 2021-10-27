package com.springsrescuemisson.kenneltracker.pet;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class PetRegistrationDto {

    private Integer id;
    private String name;
    private String type; //This is the kind of pet (dog, cat, etc.)
    private String breed;
    private String gender;
    private String color;
    private String kennelNumber;
}
