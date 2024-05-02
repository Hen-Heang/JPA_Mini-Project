package com.example.jpa.payload.banking.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserUpdateRequest{
    String name;
    String gender;
    LocalDate dob;
    String studentIdCard;
}
