package com.example.cs_finalproject.service;
import com.example.cs_finalproject.model.User;
import com.example.cs_finalproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //get all user
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    //get a user by id
    public User getUserbyId(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    //add user
    public User createUser (User user) {
        return userRepository.save(user);
    }

    //delete user
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    //update
    public User updateUser(Integer id, User newUser) {
        if(userRepository.findById(id).isEmpty()) {
            return null;
        }
        return userRepository.save(newUser);
    }
}
