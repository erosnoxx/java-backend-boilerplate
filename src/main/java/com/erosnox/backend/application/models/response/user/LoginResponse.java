package com.erosnox.backend.application.models.response.user;

import java.util.UUID;

public record LoginResponse(String token, UUID userId) {
}
