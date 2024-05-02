//package com.example.jpa.service.user;
//
//import com.example.jpa.domain.todo.Todo;
//import com.example.jpa.domain.user.User;
//import com.example.jpa.domain.user.UserRepository;
//import com.example.jpa.payload.todo.TodoRequest;
//import com.example.jpa.payload.todo.TodoResponse;
//import com.example.jpa.payload.user.UserRequest;
//import com.example.jpa.payload.user.UserResponse;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserMapper {
//    private final UserRepository userRepository;
//
//    public UserMapper(UserRepository userRepository) {
//        this.userRepository = userRepository;
//
//    }
//
//    public User todoEntity(UserRequest payload) {
//        return User.builder()
//                .name(payload.getName())
//                .role(payload.getRole())
//                .build();
//    }
//
//    public UserResponse mapToUserResponse(User user) {
//        return UserResponse.builder()
//                .id(user.getId())
//                .name(user.getName())
//                .role(user.getRole())
//                .build();
//
//
//    }
//
//    public void updateUser(User user, UserRequest userRequest){
//        user.setName(userRequest.getName());
//        user.setRole(userRequest.getRole());
//    }
//
//}
