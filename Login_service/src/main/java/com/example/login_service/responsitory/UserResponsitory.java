package com.example.login_service.responsitory;

import com.example.login_service.modules.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserResponsitory extends JpaRepository<User,Long> {
    Optional<User> findUserByEmail(String email);
}
