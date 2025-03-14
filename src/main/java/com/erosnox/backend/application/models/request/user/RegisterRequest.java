package com.erosnox.backend.application.models.request.user;

public record RegisterRequest(
        String username,
        String password) {
}
