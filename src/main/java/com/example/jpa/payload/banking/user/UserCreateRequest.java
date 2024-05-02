package com.example.jpa.payload.banking.user;

import com.example.jpa.payload.RoleRequest;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequest {
        @NotNull(message = "Pin is required")
        @Max(value = 9999, message = "Pin must be 4 digits")
        @Positive(message = "Pin must be a positive number")
        Integer pin;

        @NotBlank(message = "Phone number is required")
        @Size(max = 20, message = "Phone number must less than 20 characters")
        String phoneNumber;

        @NotBlank(message = "Password is required")
        String password;

        @NotBlank(message = "Confirmed password is required")
        String comfirmedPassword;

        @NotBlank(message = "Name is required")
        @Size(max = 40, message = "Name must be less than 40 characters")
        String name;

        @NotNull
        @Size(max = 20)
        String nationalCardId;

        @NotBlank
        @Size(max = 6)
        String gender;

        @NotNull
        LocalDate dob;

        @Size(max = 20)
        String studentIdCard;
        List<RoleRequest> roles;


}

