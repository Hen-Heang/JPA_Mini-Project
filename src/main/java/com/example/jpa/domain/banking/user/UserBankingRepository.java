package com.example.jpa.domain.banking.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserBankingRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);


    @Query("SELECT u FROM User AS u WHERE u.uuid = :uuid")
    Optional<Object> findByUuid(String uuid);


}
