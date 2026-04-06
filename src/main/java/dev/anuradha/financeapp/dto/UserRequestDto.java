package dev.anuradha.financeapp.dto;

import dev.anuradha.financeapp.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Size(min = 4)
    private String password;

    private Role role;
}
