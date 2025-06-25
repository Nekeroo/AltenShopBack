package com.altenshop.altenshopback.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterInputDTO {

    private String email;

    private String password;

    private String username;

    private String firstName;

}