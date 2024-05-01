package com.example.jpa.domain.banking.role;


import com.example.jpa.domain.banking.security.Authority;
import com.example.jpa.domain.banking.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @ManyToMany
    private List<Authority> authorities;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;



}
