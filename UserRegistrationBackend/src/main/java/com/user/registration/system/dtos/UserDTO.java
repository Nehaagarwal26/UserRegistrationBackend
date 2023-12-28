package com.user.registration.system.dtos;

import com.user.registration.system.entities.UserEntity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    @NotBlank(message = "username is mandatory and it cannot be empty or null")
    private String username;
    @NotBlank(message = "password is mandatory and it cannot be empty or null")
    private String password;
    
}