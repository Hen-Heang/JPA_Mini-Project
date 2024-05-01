package com.example.jpa.service.banking.user;


import com.example.jpa.common.api.StatusCode;
import com.example.jpa.domain.banking.role.Role;
import com.example.jpa.domain.banking.role.RoleRepository;
import com.example.jpa.domain.banking.user.User;
import com.example.jpa.domain.banking.user.UserRepository;
import com.example.jpa.exception.BusinessException;
import com.example.jpa.mapper.UserMapper;
import com.example.jpa.payload.banking.user.UserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Override
    public void createUser(UserRequest userRequest) {
        if (userRepository.existsByPhoneNumber(userRequest.getPhoneNumber())) {
            throw new BusinessException(StatusCode.PHONENUMBER_MORE_THEN_ONE);
        }


        User user = userMapper.fromUserCreateRequest(userRequest);
        user.setUuid(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setImage("avatar.png");
        user.setCreateAt(LocalDateTime.now());
        user.setIsBlocked(false);
        user.setIsDeleted(false);
        user.setIsAccountNonExpired(true);
        user.setIsAccountNonLocked(true);
        user.setIsCredentialsNonExpired(true);

        // Assign default user role
        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Role USER has not been found!"));
        roles.add(userRole);

        // set dynamic roles when create user
        userRequest.getRoles()
                .forEach(r -> {
                    Role role1 = roleRepository.findByName(r.name())
                            .orElseThrow(() -> new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "User role does not exist!"
                            ));
                    roles.add(role1);
                });

        user.setRoles(roles);

        userRepository.save(user);


    }

}
