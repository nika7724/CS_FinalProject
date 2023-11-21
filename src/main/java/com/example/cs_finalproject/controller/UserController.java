package com.example.cs_finalproject.controller;

import com.example.cs_finalproject.model.User;
import com.example.cs_finalproject.service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }
@GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }
}

