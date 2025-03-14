package com.erosnox.backend.application.usecases.user.admin;

import com.erosnox.backend.application.contracts.repositories.UserRepository;
import com.erosnox.backend.application.contracts.usecases.user.admin.FindAllUsersUsecase;
import com.erosnox.backend.application.mappers.user.UserMapper;
import com.erosnox.backend.application.models.response.user.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class FindAllUsersUsecaseImpl implements FindAllUsersUsecase {
    private final UserRepository repository;

    public FindAllUsersUsecaseImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserResponse> execute() {
        return repository.findAll().stream()
                .map(UserMapper::toResponse).collect(Collectors.toList());
    }
}
