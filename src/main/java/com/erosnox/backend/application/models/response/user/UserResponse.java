package com.erosnox.backend.application.models.response.user;

import com.erosnox.backend.application.enums.Roles;

public record UserResponse(
        String username,
        Roles role,
        boolean enabled) {
}
