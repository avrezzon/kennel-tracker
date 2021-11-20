package com.springsrescuemission.kennelmanager.model;

import lombok.Data;

@Data
public class Owner extends Contact{
    private String shelterType; //TODO this is a possible enum as well
    private Integer bedNumber;
    private String clientId;
}
