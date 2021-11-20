package com.springsrescuemission.kennelmanager.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

@Data
public class Pet {

    private String name;
    private String type; //TODO what will enums look like?
    private String breed;
    private Integer age;
    private Set<Owner> Owners;
    private Set<EmergencyContact> emergencyContacts;
    private Map<LocalDate, TimeRecord> checkIns;
    private Integer violations;

}
