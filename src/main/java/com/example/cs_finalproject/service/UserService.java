package com.example.cs_finalproject.service;
import com.example.cs_finalproject.model.ApplicationUser;
import com.example.cs_finalproject.model.Role;
import com.example.cs_finalproject.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details class");
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User is not valid"));
  }

    public List<ApplicationUser> getAllUser() {
        return userRepository.findAll();
    }

}

