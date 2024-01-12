package com.example.jpa.payload.user;

import com.example.jpa.enums.Role;
import lombok.*;


@NoArgsConstructor
@Setter
@Getter
public class UserResponse {
    private Long id;
    private String name;
    private Role role;

    @Builder
    public UserResponse(Long id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }


}
