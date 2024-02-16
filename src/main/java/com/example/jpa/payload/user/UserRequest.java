package com.example.jpa.payload.user;

import com.example.jpa.enums.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NotBlank
@NotNull
public class UserRequest {
    private String name;
    private Role role;
}
