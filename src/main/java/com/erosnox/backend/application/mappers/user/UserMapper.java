package com.erosnox.backend.application.mappers.user;

import com.erosnox.backend.application.enums.Roles;
import com.erosnox.backend.application.models.dto.UserDto;
import com.erosnox.backend.application.models.request.user.RegisterRequest;
import com.erosnox.backend.application.models.response.user.RegisterResponse;
import com.erosnox.backend.application.models.response.user.UserResponse;
import com.erosnox.backend.domain.entities.user.User;

public class UserMapper {
    public static User toEntity(RegisterRequest request, Roles role) {
        return new User(request.username(), request.password(), role);
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(user.getUsername(), user.getRole(), user.isEnabled());
    }

    public static RegisterResponse toRegisterResponse(User user) {
        return new RegisterResponse(user.getId());
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getRole());
    }
}
