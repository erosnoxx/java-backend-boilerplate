package com.erosnox.backend.application.contracts.repositories;

import com.erosnox.backend.domain.entities.user.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    User update(User user);
    void delete(User user);
    User findById(UUID id);
    User findByUsername(String username);
    List<User> findAll();
}
