package com.erosnox.backend.application.contracts.usecases.user.admin;

import com.erosnox.backend.application.models.response.user.UserResponse;
import java.util.UUID;

public interface FindUserUsecase {
    UserResponse execute(UUID userId);
}
