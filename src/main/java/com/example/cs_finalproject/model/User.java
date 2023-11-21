package com.example.cs_finalproject.model;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String lastName;

    @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String email;

    @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String password;
    public User(String firstName, String lastName ,String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}

