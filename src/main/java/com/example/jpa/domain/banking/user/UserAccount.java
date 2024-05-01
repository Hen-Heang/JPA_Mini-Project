package com.example.jpa.domain.banking.user;


import com.example.jpa.domain.banking.account.Account;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "user_account")

public class UserAccount {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        private User user;

        @ManyToOne(cascade = CascadeType.PERSIST)
        private Account account;

        private Boolean isDeleted; // manage delete status (admin want to disable or remove an account)
        private Boolean isBlocked; // manage block status (when there is bad action happened)

        private LocalDateTime createdAt;



}
