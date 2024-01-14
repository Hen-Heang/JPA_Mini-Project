package com.example.jpa.service.user;

import com.example.jpa.payload.user.UserRequest;

public interface UserService {
    void createUser(UserRequest userRequest);


    Object getAllUser(Integer page, Integer size);

    Object getUserById(Long id);

    Object updateUser(Long id, UserRequest userRequest);

    void deleteUserById(Long id);
}
