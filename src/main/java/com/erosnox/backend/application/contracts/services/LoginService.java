package com.erosnox.backend.application.contracts.services;

import com.erosnox.backend.application.models.request.user.LoginRequest;
import com.erosnox.backend.application.models.response.user.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest request);
}
