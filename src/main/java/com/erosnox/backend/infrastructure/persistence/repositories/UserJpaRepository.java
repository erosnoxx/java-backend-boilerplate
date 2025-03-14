package com.erosnox.backend.infrastructure.persistence.repositories;

import com.erosnox.backend.infrastructure.persistence.entities.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    UserDetails findUserByUsername(String username);
    UserEntity findByUsername(String username);
}
