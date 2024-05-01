package com.example.jpa.domain.banking.account_type;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "account_types")
public class AccountType{
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false, length = 100)
    private String alias;

    @Column(unique = true, nullable = false, length = 100)
    private String name;

    @Column(columnDefinition = "Text")
    private String description;



}
