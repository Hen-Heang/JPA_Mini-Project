//package com.example.jpa.service.user;
//
//import com.example.jpa.domain.user.User;
//import com.example.jpa.domain.user.UserRepository;
//import com.example.jpa.exception.CusNotFoundException;
//import com.example.jpa.payload.user.UserMainRes;
//import com.example.jpa.payload.user.UserRequest;
//import com.example.jpa.payload.user.UserResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//    private final UserMapper userMapper;
//
//    @Override
//    public void createUser(UserRequest userRequest) {
//        var user = userMapper.todoEntity(userRequest);
//        userRepository.save(user);
//
//    }
//
//    @Override
//    public Object getAllUser(Integer page, Integer size) {
//        var usrList = userRepository.findAll();
//        List<UserResponse> users = usrList.stream()
//                .map(userMapper::mapToUserResponse)
//                .toList();
//        return new UserMainRes(users);
//    }
//
//    @Override
//    public Object getUserById(Long id) {
//        return userRepository.findById(id)
//                .map(userMapper::mapToUserResponse)
//                .orElseThrow(() -> new CusNotFoundException("UserBanking Not Found!"));
//    }
//
//    @Override
//    public Object updateUser(Long id, UserRequest userRequest) {
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new CusNotFoundException("UserBanking Not Found!"));
//        userMapper.updateUser(user, userRequest);
//        return userRepository.save(user);
//    }
//
//    @Override
//    public void deleteUserById(Long id) {
//        userRepository.deleteById(id);
//    }
//}
