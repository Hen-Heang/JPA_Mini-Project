package com.example.jpa.service.banking.user;

import com.example.jpa.payload.banking.user.UserRequest;

public interface UserService {
    void createUser(UserRequest userRequest);

}
