package com.erosnox.backend.infrastructure.repositories;

import com.erosnox.backend.application.contracts.repositories.UserRepository;
import com.erosnox.backend.application.exceptions.NotFoundException;
import com.erosnox.backend.domain.entities.user.User;
import com.erosnox.backend.infrastructure.mappers.UserJpaMapper;
import com.erosnox.backend.infrastructure.persistence.repositories.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private UserJpaRepository repository;

    @Override
    public User save(User user) {
        var jpaUser = UserJpaMapper.toJpa(user);
        var savedUser = repository.save(jpaUser);
        return UserJpaMapper.toEntity(savedUser);
    }

    @Override
    public User update(User user) {
        var jpaUser = UserJpaMapper.toJpa(user);
        jpaUser.setId(user.getId());
        var savedUser = repository.save(jpaUser);
        return UserJpaMapper.toEntity(savedUser);
    }

    @Override
    public void delete(User user) {
        var userToDelete = repository.findById(user.getId()).orElseThrow(
                () -> new NotFoundException("User not found"));

        repository.delete(userToDelete);
    }

    @Override
    public User findById(UUID id) {
        var user = repository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return UserJpaMapper.toEntity(user);
    }

    @Override
    public User findByUsername(String username) {
        var user = repository.findByUsername(username);
        return UserJpaMapper.toEntity(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream()
                .map(UserJpaMapper::toEntity).collect(Collectors.toList());
    }
}
