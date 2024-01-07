package com.example.cs_finalproject.controller;

import com.example.cs_finalproject.model.ApplicationUser;
import com.example.cs_finalproject.model.LoginResponseDTO;
import com.example.cs_finalproject.model.RegistrationDTO;
import com.example.cs_finalproject.service.AuthenticationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuntenticationController {
    private AuthenticationService authenticationService;

    public AuntenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ApplicationUser registerUser(@RequestBody RegistrationDTO body) {
        return authenticationService.registerUser(body.getUsername(), body.getPassword());
    }

    @PostMapping("/login")
    public LoginResponseDTO loginResponseDTO(@RequestBody RegistrationDTO body) {
        return authenticationService.loginUser(body.getUsername(), body.getPassword());
    }


}
