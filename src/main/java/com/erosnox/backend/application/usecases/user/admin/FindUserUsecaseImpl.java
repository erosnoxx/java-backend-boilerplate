package com.erosnox.backend.application.usecases.user.admin;

import com.erosnox.backend.application.contracts.repositories.UserRepository;
import com.erosnox.backend.application.contracts.usecases.user.admin.FindUserUsecase;
import com.erosnox.backend.application.mappers.user.UserMapper;
import com.erosnox.backend.application.models.response.user.UserResponse;
import java.util.UUID;

public class FindUserUsecaseImpl implements FindUserUsecase {
    private final UserRepository repository;

    public FindUserUsecaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse execute(UUID userId) {
        var response = repository.findById(userId);

        return UserMapper.toResponse(response);
    }
}
