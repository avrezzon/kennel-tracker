package com.springsrescuemission.kennelmanager.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document("Kennel")
public class Kennel {

    @Id
    String someIdentifier;
    Map<Integer, Cage> cage;

}
