package com.springsrescuemission.kenneltracker.timesheetservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeSheetController {

    @GetMapping("/hello")
    public String helloWorld(){
        return "hello";
    }



}
