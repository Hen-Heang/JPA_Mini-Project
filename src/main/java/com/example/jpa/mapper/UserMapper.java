package com.example.jpa.mapper;



import com.example.jpa.domain.banking.user.User;
import com.example.jpa.domain.banking.user.UserAccount;
import com.example.jpa.payload.banking.user.UserCreateRequest;
import com.example.jpa.payload.banking.user.UserDetailResponse;
import com.example.jpa.payload.banking.user.UserResponse;
import com.example.jpa.payload.banking.user.UserUpdateRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromUserCreateRequest (UserCreateRequest userCreateRequest);

   UserDetailResponse toUserDetailsResponse(User user);

    @BeanMapping(nullValuePropertyMappingStrategy =
            NullValuePropertyMappingStrategy.IGNORE)
    void fromUserUpdateRequest(UserUpdateRequest userUpdateRequest, @MappingTarget User userBanking);

    UserResponse toUserResponse(User userBanking);

    @Named("mapUserResponse")
    default UserResponse mapUserResponse(List<UserAccount> userAccountList){
        return toUserResponse(userAccountList.get(0).getUser());
    }

    default void updateUserByUUID(User user, UserUpdateRequest userUpdateRequest){
        user.setName(userUpdateRequest.getName());
        user.setGender(userUpdateRequest.getGender());
        user.setDob(userUpdateRequest.getDob());
        user.setStudentIdCard(userUpdateRequest.getStudentIdCard());
    }

}
