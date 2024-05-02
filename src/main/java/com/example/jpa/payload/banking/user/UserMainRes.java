package com.example.jpa.payload.banking.user;

import com.example.jpa.common.Pagination;

import java.util.List;

public record UserMainRes(
        List<UserResponse> userResponses,
        Pagination pagination

) {

}
