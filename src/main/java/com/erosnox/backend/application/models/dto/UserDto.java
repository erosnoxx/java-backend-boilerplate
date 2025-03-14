package com.erosnox.backend.application.models.dto;

import com.erosnox.backend.application.enums.Roles;

import java.util.UUID;

public record UserDto(UUID id, Roles role) {
}
