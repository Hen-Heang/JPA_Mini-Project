package com.example.jpa.service.banking.user;


import com.example.jpa.common.api.StatusCode;
import com.example.jpa.domain.banking.role.Role;
import com.example.jpa.domain.banking.role.RoleRepository;
import com.example.jpa.domain.banking.user.User;
import com.example.jpa.domain.banking.user.UserBankingRepository;
import com.example.jpa.domain.category.Category;
import com.example.jpa.exception.BusinessException;
import com.example.jpa.exception.CusNotFoundException;
import com.example.jpa.mapper.UserMapper;
import com.example.jpa.payload.banking.user.UserCreateRequest;
import com.example.jpa.payload.banking.user.UserUpdateRequest;
import com.example.jpa.payload.category.CategoryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserBankingServiceImpl implements UserBankingService {
    private final UserBankingRepository userBankingRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    @Override
    public void createUser(UserCreateRequest userCreateRequest) {
        if (userBankingRepository.existsByPhoneNumber(userCreateRequest.getPhoneNumber())) {
            throw new BusinessException(StatusCode.PHONENUMBER_MORE_THEN_ONE);
        }

        User userBanking = userMapper.fromUserCreateRequest(userCreateRequest);
        userBanking.setUuid(UUID.randomUUID().toString());
        userBanking.setProfileImage("avatar.png");
        userBanking.setCreatedAt(LocalDateTime.now());
        userBanking.setIsBlocked(false);
        userBanking.setIsDeleted(false);

        // Assign default userBanking role
        List<Role> roles = new ArrayList<>();
        Role userRole = roleRepository.findByName("USER")
                .orElseThrow(() -> new BusinessException(StatusCode.ROLE_NOT_FOUND));
        roles.add(userRole);

        // set dynamic roles when create userBanking
        userCreateRequest.getRoles()
                .forEach(r -> {
                    Role role1 = roleRepository.findByName(r.name())
                            .orElseThrow(() -> new BusinessException(StatusCode.ROLE_NOT_FOUND));
                    roles.add(role1);
                });
        userBanking.setRoles(roles);
        roles.add(userRole);
        userBankingRepository.save(userBanking);


    }

    @Override
    public void updateUserByUuid(String uuid, UserUpdateRequest userUpdateRequest) {

        User user = (User) userBankingRepository.findByUuid(uuid)
                .orElseThrow(() -> new BusinessException(StatusCode.USER_NOT_FOUND));
        userMapper.updateUserByUUID(user, userUpdateRequest);
        userBankingRepository.save(user);

    }

    @Override
    public Object getAllUser(Pageable pageable) {

        return null;
    }
}
