package com.erosnox.backend.application.usecases.user.auth;

import com.erosnox.backend.application.contracts.repositories.UserRepository;
import com.erosnox.backend.application.contracts.usecases.user.auth.RegisterUsecase;
import com.erosnox.backend.application.enums.Roles;
import com.erosnox.backend.application.mappers.user.UserMapper;
import com.erosnox.backend.application.models.request.user.RegisterRequest;
import com.erosnox.backend.application.models.response.user.RegisterResponse;
import com.erosnox.backend.infrastructure.mappers.UserJpaMapper;
import com.erosnox.backend.infrastructure.persistence.entities.user.UserEntity;

public class RegisterUsecaseImpl implements RegisterUsecase {
    private final UserRepository repository;

    public RegisterUsecaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public RegisterResponse execute(RegisterRequest request, Roles role) {
        var user = UserMapper.toEntity(request, role);
        var savedUser = repository.save(user);
        return UserMapper.toRegisterResponse(savedUser);
    }
}
