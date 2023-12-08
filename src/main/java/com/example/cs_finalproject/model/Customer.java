package com.example.cs_finalproject.model;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String firstName;

    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String lastName;

    @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String address;

     @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String email;

    @ManyToOne
    @JoinColumn(name = "status", foreignKey = @ForeignKey(name = "fk_status"), referencedColumnName = "id")
    private Status status;

    public Customer(String firstName, String lastName, String address, String email, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.status = status;

    }
}