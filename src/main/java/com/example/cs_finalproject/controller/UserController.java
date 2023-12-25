package com.example.cs_finalproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @GetMapping("/")
    public String helloUserController() {
        return "User access level";
    }

}


//package com.example.cs_finalproject.controller;
//
//import com.example.cs_finalproject.model.Customer;
//import com.example.cs_finalproject.model.User;
//import com.example.cs_finalproject.repository.UserRepository;
//import com.example.cs_finalproject.service.UserService;
//import jakarta.websocket.server.PathParam;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(final UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userService.getAllUser();
//    }
//
//
//    @GetMapping("/user/{id}")
//    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
//        User user = userService.getUserbyId(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//      @PostMapping("/user")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User newUser = userService.createUser(user);
//        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PutMapping("/user/{id}")
//    public ResponseEntity<User> updateUser(@RequestBody User newUser, @PathVariable("id") Integer id) {
//        return new ResponseEntity<>(userService.updateUser(id, newUser), HttpStatus.OK);
//    }
//
//}