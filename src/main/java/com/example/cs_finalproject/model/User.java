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
    private String username;

    @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String email;

    @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String password;
    public User(String username ,String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}

