package com.example.jpa.mapper;



import com.example.jpa.domain.banking.user.User;
import com.example.jpa.domain.banking.user.UserAccount;
import com.example.jpa.payload.banking.user.UserDetailResponse;
import com.example.jpa.payload.banking.user.UserRequest;
import com.example.jpa.payload.banking.user.UserResponse;
import com.example.jpa.payload.banking.user.UserUpdateRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromUserCreateRequest (UserRequest userRequest);

   UserDetailResponse toUserDetailsRespone(User user);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    void fromUserUpdateRequest(UserUpdateRequest userUpdateRequest, @MappingTarget User user);

    UserResponse toUserResponse(User user);

    @Named("mapUserResponse")
    default UserResponse mapUserResponse(List<UserAccount> userAccountList){
        return toUserResponse(userAccountList.get(0).getUser());
    }


}
