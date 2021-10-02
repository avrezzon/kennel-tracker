package com.springsrescuemisson.kenneltracker.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PetDto {

    private String id;
    private String name;
    private String type; //This is the kind of pet (dog, cat, etc.)
    private String breed;
    private String gender;
    private String color;
    private String kennelNumber;
}
