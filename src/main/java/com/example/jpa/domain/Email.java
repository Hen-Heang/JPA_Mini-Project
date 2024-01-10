package com.example.jpa.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Email {
    private String toEmail;
    private String sendNumber;
    private String subject;
    private String body;
}
