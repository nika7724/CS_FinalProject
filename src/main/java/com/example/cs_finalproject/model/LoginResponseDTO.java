package com.example.cs_finalproject.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class LoginResponseDTO {

    private ApplicationUser applicationUser;
    private String jwt;
}
