package com.erosnox.backend.infrastructure.services;

import com.erosnox.backend.application.contracts.services.LoginService;
import com.erosnox.backend.application.models.request.user.LoginRequest;
import com.erosnox.backend.application.models.response.user.LoginResponse;
import com.erosnox.backend.infrastructure.config.authorization.TokenService;
import com.erosnox.backend.infrastructure.persistence.entities.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(
                request.username(), request.password());
        var authentication = authenticationManager.authenticate(usernamePassword);

        Map<String, Object> tokenResponse = this.tokenService.generateToken(
                (UserEntity) authentication.getPrincipal());

        String token = (String) tokenResponse.get("token");

        return new LoginResponse(token, ((UserEntity) authentication.getPrincipal()).getId());
    }
}
