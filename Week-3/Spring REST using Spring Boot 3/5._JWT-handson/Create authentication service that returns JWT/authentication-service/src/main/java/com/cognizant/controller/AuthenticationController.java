package com.cognizant.authenticationservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.authenticationservice.model.JwtResponse;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public JwtResponse authenticate() {

        String token = "sample-jwt-token";

        return new JwtResponse(token);
    }
}