package com.erosnox.backend.application.contracts.usecases.user.auth;

import com.erosnox.backend.application.enums.Roles;
import com.erosnox.backend.application.models.request.user.RegisterRequest;
import com.erosnox.backend.application.models.response.user.RegisterResponse;

public interface RegisterUsecase {
    RegisterResponse execute(RegisterRequest request, Roles role);
}
