package com.example.jpa.service.banking.user;

import com.example.jpa.payload.banking.user.UserCreateRequest;
import com.example.jpa.payload.banking.user.UserUpdateRequest;
import org.springframework.data.domain.Pageable;

public interface UserBankingService {
    void createUser(UserCreateRequest userCreateRequest);

    void updateUserByUuid(String uuid, UserUpdateRequest userCreateRequest);

    Object getAllUser(Pageable pageable);
}
