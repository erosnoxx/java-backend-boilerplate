package com.erosnox.backend.application.usecases.user.auth;

import com.erosnox.backend.application.contracts.services.LoginService;
import com.erosnox.backend.application.contracts.usecases.user.auth.LoginUsecase;
import com.erosnox.backend.application.models.request.user.LoginRequest;
import com.erosnox.backend.application.models.response.user.LoginResponse;

public class LoginUsecaseImpl implements LoginUsecase {
    private final LoginService loginService;

    public LoginUsecaseImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public LoginResponse execute(LoginRequest request) {
        return loginService.login(request);
    }
}
