package com.example.cs_finalproject;
import com.example.cs_finalproject.model.ApplicationUser;
import com.example.cs_finalproject.model.Role;
import com.example.cs_finalproject.repository.RoleRepository;
import com.example.cs_finalproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class CsFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsFinalProjectApplication.class, args);
    }

}