package com.erosnox.backend.application.contracts.usecases.user.auth;

import com.erosnox.backend.application.models.request.user.LoginRequest;
import com.erosnox.backend.application.models.response.user.LoginResponse;

public interface LoginUsecase {
    LoginResponse execute(LoginRequest request);
}
