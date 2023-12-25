package com.example.cs_finalproject.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, columnDefinition = "VARCHAR(30) NOT NULL")
    private String statusName;

    @OneToMany
            (mappedBy = "status", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JsonBackReference
    Set<Customer> customer = new HashSet<>();

    public Status(String statusName) {
        this.statusName = statusName;
    }


}

