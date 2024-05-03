package com.mbti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbti.config.error.InvalidDataException;

@Controller
public class DataController {


    @GetMapping("/validate")
    public String validateData(String data) {
    	System.out.println(data);
        if (data == null || data.isEmpty()) {
            throw new InvalidDataException("Data cannot be null or empty");
        }
        if (data.length() < 5) {
            throw new InvalidDataException("Data must be at least 5 characters long");
        }
        return "Data is valid!";
    }
}