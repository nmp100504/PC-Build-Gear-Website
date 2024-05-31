package com.example.BuildPC.dtos;

import com.example.BuildPC.models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotEmpty(message = "The email is required")
    private String email;
    @NotEmpty(message = "The firstName is required")
    private String firstName;
    @NotEmpty(message = "The lastName is required")
    private String lastName;
    @NotEmpty(message = "The password is required")
    private String password;
    @Size(max = 10, message = "The description cannot exceed 10 characters")
    private String phone;

    @NotEmpty(message = "The role is required")
    private String role;
}
